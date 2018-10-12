package com.winter.utils;
//implementation org.bitcoinj:bitcoinj-core:0.14.7
//implementation org.web3j:core:3.3.1-android
import java.security.SecureRandom;

public class BlockChainUtils {






/*
  private static final SecureRandom SECURE_RANDOM;

    static {
        if (isAndroidRuntime()) {
            new LinuxSecureRandom();
        }
        SECURE_RANDOM = new SecureRandom();
    }

    public static SecureRandom secureRandom() {
        return SECURE_RANDOM;
    }

    // Taken from BitcoinJ implementation
    // https://github.com/bitcoinj/bitcoinj/blob/3cb1f6c6c589f84fe6e1fb56bf26d94cccc85429/core/src/main/java/org/bitcoinj/core/Utils.java#L573
    private static int isAndroid = -1;

    static boolean isAndroidRuntime() {
        if (isAndroid == -1) {
            final String runtime = System.getProperty("java.runtime.name");
            isAndroid = (runtime != null && runtime.equals("Android Runtime")) ? 1 : 0;
        }
        return isAndroid == 1;
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

    public static ShellWallet generateWallet(int coinType, int index, String name) throws Exception {
        ShellWallet wallet = null;
        if (words == null || words.size() != 12) {
            throw new RuntimeException("please generateMnemonic first");
        } else {
            DeterministicSeed deterministicSeed = new DeterministicSeed(words, null, "", 0);
            DeterministicKeyChain deterministicKeyChain = DeterministicKeyChain.builder().seed(deterministicSeed).build();
            //拼接路径 path = "m/44'/60'/0'/0/0"
            String path = null;
            if (coinType == BTC_COIN) {
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
                LogUtils.d("pub2:" + publicKey);
                String privateKey = ecKey.getPrivateKeyEncoded(networkParameters).toString();
                String address = ecKey.toAddress(networkParameters).toString();

                wallet = new ShellWallet(index, coinType, privateKey, publicKey, address, name);
                LogUtils.d(wallet.toString());
            } else if (coinType == ETH_COIN) {
                path = "m/44'/60'/0'/0/" + index;
                BigInteger privkeyeth = deterministicKeyChain.getKeyByPath(parsePath(path), true).getPrivKey();
                ECKeyPair ecKeyPair = ECKeyPair.create(privkeyeth);

                String publicKey = Numeric.toHexStringWithPrefix(ecKeyPair.getPublicKey());
                String privateKey = Numeric.toHexStringWithPrefix(ecKeyPair.getPrivateKey());
                String address = "0x" + Keys.getAddress(ecKeyPair);

                wallet = new ShellWallet(index, coinType, privateKey, publicKey, address, name);
                LogUtils.d(wallet.toString());
            }

        }

        return wallet;
    }
    */


}
