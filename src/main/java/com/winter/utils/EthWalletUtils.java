package com.winter.utils;
//implementation org.bitcoinj:bitcoinj-core:0.14.7
//implementation org.web3j:core:3.3.1-android
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import com.winter.model.VisionWallet;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.wallet.DeterministicKeyChain;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.utils.Numeric;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;

import org.bitcoinj.core.*;
import org.bitcoinj.crypto.MnemonicCode;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.wallet.DeterministicSeed;

import javax.annotation.Nonnull;

public class EthWalletUtils {
    public static final String ropstenService = "https://ropsten.infura.io/mew";//模仿 myEtherWallet 钱包请求 infura 网络
    private static final SecureRandom SECURE_RANDOM;
    public static final String account1 = "我的测试钱包地址";
    public static final String account2 = "我的测试钱包地址2";

    public static final String account1Pri = "我的测试钱包地址1私钥";//私钥
    public static final String account2Pri = "我的测试钱包地址2私钥";//私钥

    public static final String MttContractAddress = "部署的erc20 的合约地址";
    private List<String> words = new ArrayList<>();

    //连接钱包节点【后续所有操作都需要钱包节点广播出去】
    Web3j web3j = Web3j.build(new HttpService("http://localhost:5201314/"));
    Web3ClientVersion web3ClientVersion;
    public String getClientVersion() {
        try {
           web3ClientVersion = web3j.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            return clientVersion;
        } catch (Exception e) {
            //  logger.error("load contract error", e);
            return null;
        }
    }
    public String getNewAddress() {
        try {
             File file = new File("/home/wallet");
            WalletUtils.generateNewWalletFile("指定好钱包的密码", file, true);
            Credentials credentials = WalletUtils.loadCredentials("密码", file);
            return credentials.getAddress();
        } catch (Exception e) {
            //  logger.error("load contract error", e);
            return null;
        }
    }
    public static void close(Web3j web3j){
        web3j.shutdown();
    }

    public BigDecimal getBalance() {
        BigDecimal nbalance =new BigDecimal("0.0");
        try {
            EthGetBalance ethGetBalance = web3j.ethGetBalance("0xb86d57174bf8c53f1084be7f565f9fd9dabd87d0", DefaultBlockParameter.valueOf("latest")).send();
            //eth默认会部18个0这里处理比较随意，大家可以随便处理哈
            BigDecimal balance = new BigDecimal(ethGetBalance.getBalance().divide(new BigInteger("10000000000000")).toString());
            nbalance = balance.divide(new BigDecimal("100000"), 8, BigDecimal.ROUND_DOWN);

        } catch (Exception e) {

        }
        return nbalance;
    }
    public static Contract getERC20Contract(Web3j web3j,String contractAddress,String userPri){
        BigInteger GAS_PRICE = BigInteger.valueOf(22_000_000_000L);
        BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000);

        Credentials credentials = Credentials.create(userPri);//获得信任凭证

        EthContract contract = EthContract.load( contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
        return contract;
    }
    public static String getERC20Balance(Web3j web3j,Contract contract,String userAddress,int decimal) throws Exception{

//		Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();//send 是同步请求
//		Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get(); //sendAsync(), 使用CompletableFuture（Android上的Future）发送异步请求：
//		String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//		System.out.println(clientVersion);//查看版本信息
        //或者 RxJava Observable：
		/*Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
		web3.web3ClientVersion().observable().subscribe(x -> {
		    String clientVersion = x.getWeb3ClientVersion();
		    ...
		});*/


        RemoteCall<BigInteger> balanceOf = ((EthContract) contract).balanceOf(userAddress);
        BigInteger send2 = balanceOf.send();
        String result = toDecimal(8, send2);
        System.out.println(result);
        return result;
    }
    public static String toDecimal(int decimal,BigInteger integer){
//		String substring = str.substring(str.length() - decimal);
        StringBuffer sbf = new StringBuffer("1");
        for (int i = 0; i < decimal; i++) {
            sbf.append("0");
        }
        String balance = new BigDecimal(integer).divide(new BigDecimal(sbf.toString()), 18, BigDecimal.ROUND_DOWN).toPlainString();
        return balance;
    }



    public String Transfer(File file,String toAddress,int amount,BigInteger gasPrice,BigInteger gasLimit) {
        try {
      //      BigInteger value = Convert.toWei(bigDecimalValue, Convert.Unit.ETHER).toBigInteger();
    Credentials credentials = WalletUtils.loadCredentials("转出地址密码", file);
    String fromAddress = credentials.getAddress();
    EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
            fromAddress, DefaultBlockParameterName.LATEST).sendAsync().get();
    BigInteger nonce = ethGetTransactionCount.getTransactionCount();//web3j.ethGetTransactionCount(address,DefaultBlockParameterName.LATEST).sendAsync().get().getTransactionCount();
    Address address = new Address(toAddress);
    Uint256 value = new Uint256(amount);
    List<Type> parametersList = new ArrayList<>();
    parametersList.add(address);
    parametersList.add(value);
    List<TypeReference<?>> outList = new ArrayList<>();
    Function function = new Function("transfer", parametersList, outList);
    String encodedFunction = FunctionEncoder.encode(function);

    RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice,            gasLimit, toAddress, encodedFunction);
    byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
    String hexValue = Numeric.toHexString(signedMessage);

    EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();
    return ethSendTransaction.getTransactionHash();
        } catch (Exception e) {
            //  logger.error("load contract error", e);
            return null;
        }
}



    static {
           new LinuxSecureRandom();
                SECURE_RANDOM = new SecureRandom();
    }

    public static SecureRandom secureRandom() {
        return SECURE_RANDOM;
    }

    public void generateMnemonic(Context context) throws Exception {
        String path = EthWalletUtils.class.getClassLoader().getResource("config/test/en-mnemonic-word-list.txt").getPath();
      //  类加载器获取文件路径：class.getClassLoader().getResource(" xx ").getPath();
      //  类获取文件路径：class.getResource(" /xx ").getPath();
      //  获取工程根目录：System.getProperty("user.dir");
        MnemonicCode mnemonicCode = new MnemonicCode(FileUtils.getInputStream(path), null);
        SecureRandom secureRandom = secureRandom();
        byte[] initialEntropy = new byte[16];//算法需要，必须是被4整除
        secureRandom.nextBytes(initialEntropy);
        List<String> wd = mnemonicCode.toMnemonic(initialEntropy);
        if (wd == null || wd.size() != 12)
            throw new RuntimeException("generate word error");
        else {
            words.clear();
            words.addAll(wd);
           // Log.d("sss", words.toString());
        }
        generateWallet(1, 1, "testWallet");
    }
    public static List<ChildNumber> parsePath(@Nonnull String path) {
        String[] parsedNodes = path.replace("m", "").split("/");
        List<ChildNumber> nodes = new ArrayList<>();

        for (String n : parsedNodes) {
            n = n.replaceAll(" ", "");
            if (n.length() == 0) continue;
            boolean isHard = n.endsWith("'");
            if (isHard) n = n.substring(0, n.length() - 1);
            int nodeNumber = Integer.parseInt(n);
            nodes.add(new ChildNumber(nodeNumber, isHard));
        }

        return nodes;
    }

    public VisionWallet generateWallet(int coinType, int index, String name) throws Exception {
        VisionWallet wallet = null;
        Boolean BTC_TEST_NET=true;
        if (words == null || words.size() != 12) {
            throw new RuntimeException("please generateMnemonic first");
        } else {
            DeterministicSeed deterministicSeed = new DeterministicSeed(words, null, "", 0);
            DeterministicKeyChain deterministicKeyChain = DeterministicKeyChain.builder().seed(deterministicSeed).build();
            //拼接路径 path = "m/44'/60'/0'/0/0"
            String path = null;
            if (coinType == 0) {//BTC_COIN
                path = "m/44'/0'/0'/0/" + index;
                NetworkParameters networkParameters = null;
                if (!BTC_TEST_NET) {
                    networkParameters = MainNetParams.get();
                } else {
                    networkParameters = TestNet3Params.get();
                    path = "m/44'/1'/0'/0/" + index;
                }
                BigInteger privkeybtc = deterministicKeyChain.getKeyByPath(parsePath(path), true).getPrivKey();
                ECKey ecKey = ECKey.fromPrivate(privkeybtc);

                //String publicKey = Numeric.toHexStringNoPrefixZeroPadded(new BigInteger(ecKey.getPubKey()), 66);
                //LogUtils.d("pub1:" + publicKey );
                String publicKey = ecKey.getPublicKeyAsHex();
           //     LogUtils.d("pub2:" + publicKey);
                String privateKey = ecKey.getPrivateKeyEncoded(networkParameters).toString();
                String address = ecKey.toAddress(networkParameters).toString();

                wallet = new VisionWallet(index, coinType, privateKey, publicKey, address, name);
               // LogUtils.d(wallet.toString());
            } else if (coinType == 1) {//ETH_COIN
                path = "m/44'/60'/0'/0/" + index;
                BigInteger privkeyeth = deterministicKeyChain.getKeyByPath(parsePath(path), true).getPrivKey();
                ECKeyPair ecKeyPair = ECKeyPair.create(privkeyeth);

                String publicKey = Numeric.toHexStringWithPrefix(ecKeyPair.getPublicKey());
                String privateKey = Numeric.toHexStringWithPrefix(ecKeyPair.getPrivateKey());
                String address = "0x" + Keys.getAddress(ecKeyPair);

                wallet = new VisionWallet(index, coinType, privateKey, publicKey, address, name);
                //LogUtils.d(wallet.toString());
            }

        }

        return wallet;
    }



}
