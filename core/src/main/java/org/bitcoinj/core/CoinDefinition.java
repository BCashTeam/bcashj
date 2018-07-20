package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "BCash";
    public static final String coinTicker = "BCASH";
    public static final String coinURIScheme = "bcash";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/dash/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.bcashpay.org/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.explorer.bcashpay.org/";

    public static final String DONATION_ADDRESS = "BFGqLZZmKGiyuiwNmkDRACJMa15Ax3jBkg";  //Developer donation BCASH address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(1 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 60000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 1000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 DASH (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    //
    // Dash 0.12.1.x
    //
    public static final int PROTOCOL_VERSION = 70208;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70208;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 19801;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 29801;     //protocol.h GetDefaultPort(testnet=true)

    //
    //  Production
    //
    public static final int AddressHeader = 25;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0x049e04cf;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1519344000L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (1321675);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "000002320db441472782a6e357c77a614eb1df4828433804073a404cb66d20cb"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "b033fee3e137b49c2573889fef4bea46f01935e8ad1cb7c9da9940b3774e60ea";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    static public String genesisTxInBytes = "04ffff001d01044c5957697265642030392f4a616e2f3230313420546865204772616e64204578706572696d656e7420476f6573204c6976653a204f76657273746f636b2e636f6d204973204e6f7720416363657074696e6720426974636f696e73";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "node1.bcashpay.org",
            "node2.bcashpay.org",
            "node3.bcashpay.org",
    };


    public static int minBroadcastConnections = 0;   //0 for default; Using 3 like BreadWallet.

    //
    // TestNet - DASH
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 140;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "000009bc9a2af8ee147ff76f893ae300b7964b15b6bb838a490aab34f1428869";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1519344001L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (875522L);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(100, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210240;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.dashdot.io",
            "test.dnsseed.masternode.io",
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "049e04cf3d1b0cc16fa40efbf62f448926266caa42df123e16947989e87c7a2c2a1bd645532153a8eb8cddb83273a0df7e6daf6872b3d7329a206a5b67d268d4b7";
    public static final String TESTNET_SATOSHI_KEY = "04ea1afd3291c97a579580eeb158fe3eadb028eb133c60136e82682290020d93f8510f417e83fcf2dc46a1a3d77d9215126494788b3f0ba6e2401fca7b70085809";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.darkcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.darkcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

        checkpoints.put(  0, Sha256Hash.wrap("000002320db441472782a6e357c77a614eb1df4828433804073a404cb66d20cb"));
        checkpoints.put(  99013, Sha256Hash.wrap("00000000005abcc7fd81d2cd31c759e33a9f72c99e21e485872932fc3f2c02bf"));
        
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
