package secureCommunication;

import response.Dispatcher;
import response.Receiver;
import response.Response;
import response.ResponseManager;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 5/15/17.
 */
public class SecureCommunication implements Dispatcher {


    private static SecureCommunication secureCommunication;
    private static String currentUsername;
    private List<Receiver> receiverList;
    private int login;
    private Connection connection;
    private final String ADDR = "https://path/to/the/web"; //name of the Rest web service provider
    private final String SYNCH = "/synchronization";
    private final String SUBMIT_PROJECT = "/submit/project/new";
    private final String SUBMIT_OBJECTIVE = "/submit/objective/new";
    private final String SUBMIT_TASK = "/submit/task/new";
    private final String DATABASE_URL = "https://path-to-database";
    private final int TIMEOUT = 5000; //timeout for the connections
    private URL url = null;
    private URLConnection urlConnection = null;

    private static SSLEngine sslEngine;
    private static SSLContext sslContext;
    private final String[] connectionProtocols = {"TLSv1.2"};
    //private final String[] suites = {"TLS_ECDHE_RSA_WTIH_AES_256_CBC_SHA"};


    private SecureCommunication() {
        receiverList = new ArrayList<>();
        ResponseManager.addDispatcher(this, "login");
        login = 0;
    }

    public URLConnection getUrlConnection(){
        return urlConnection;
    }

    public static SecureCommunication getSecureCommunication() {
        if (secureCommunication == null) {
            secureCommunication = new SecureCommunication();
        }
        return secureCommunication;
    }


    public void createSslDatabaseConnection() {

    }

    public void closeSslDatabaseConnection() {

    }

    public void initiateConnectionWithSsl(String url) {
        try {
            this.url = new URL(ADDR + url);
            urlConnection = this.url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Encountered IOException in openning url connection.");
        }

        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return super.getPasswordAuthentication();
            }
        });

        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "text/plain");
        urlConnection.setConnectTimeout(TIMEOUT);
        urlConnection.setReadTimeout(TIMEOUT);

        char[] passphrase = "g0dzax".toCharArray();
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("/resources/certificate/cacerts"), passphrase);
        } catch (KeyStoreException e) {
            e.printStackTrace();
            System.out.println("Encountered keyStore exception.");
        } catch (CertificateException e) {
            e.printStackTrace();
            System.out.println("Encountered certificate exception.");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("Encountered nosuchalgorithm exception.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Encountered no file found exception.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Encountered IOException.");
        }

        TrustManagerFactory trustManagerFactory = null;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(keyStore);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("Encountered nosuchalgorithm in trustmanager.");
        } catch (KeyStoreException e) {
            e.printStackTrace();
            System.out.println("Encountered keystore exception in trustmanager initialization.");
        }

        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("Encountered nosuchalgorithm exception in getting instance of sslcontext.");
        } catch (KeyManagementException e) {
            e.printStackTrace();
            System.out.println("Encountered keymanagement exception in initiating sslcontext.");
        }


        sslEngine = sslContext.createSSLEngine(this.url.getHost(), 6232);
        sslEngine.setUseClientMode(true);
        sslEngine.setEnabledProtocols(connectionProtocols);
        try {
            sslEngine.beginHandshake();
        } catch (SSLException e) {
            e.printStackTrace();
            System.out.println("Encountered exception in begining handshake of connection");
        }
    }




    @Override
    public void addReceiver(Receiver receiver) {
        receiverList.add(receiver);
    }

    @Override
    public void removeReceiver(Receiver receiver) {
        for (Receiver r : receiverList) {
            if (r.equals(receiver)) {
                receiverList.remove(r);
            }
        }
    }

    @Override
    public void sendResponse(Response response) {
        for (Receiver receiver : receiverList) {
            receiver.update(response);
        }
    }

    @Override
    public String getTypeOfReceiver() {
        return "login";
    }
}
