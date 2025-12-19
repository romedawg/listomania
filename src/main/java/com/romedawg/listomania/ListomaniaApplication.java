package com.romedawg.listomania;

import com.couchbase.client.core.env.IoConfig;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.env.ClusterEnvironment;
import com.couchbase.client.java.kv.GetResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;

@SpringBootApplication
public class ListomaniaApplication {

	static String connectionString = "_couchbase._tcp.qa.internal.gohealth.net";
	static String username = "rome";
	static String password = "Snick3rs!";
	static String bucketName = "calltron_dev";

	public static void main(String[] args) {
//		SpringApplication.run(ListomaniaApplication.class, args);

		System.out.println("I'm alive");
		calltron();
	}

	public static void calltron(){
		System.out.println("starting calltron connection");
        Cluster cluster = Cluster.connect(
                connectionString,
                ClusterOptions.clusterOptions(username, password).environment(env -> {
                    // Sets a pre-configured profile called "wan-development" to help avoid
                    // latency issues when accessing Capella from a different Wide Area Network
                    // or Availability Zone (e.g. your laptop).
                    ClusterEnvironment.builder().ioConfig(IoConfig.enableDnsSrv(true)).build();
                })
        );

//		Cluster cluster = Cluster.connect(connectionString, "Administrator", "password");
		cluster.waitUntilReady(Duration.ofSeconds(10));

		// Get a bucket reference
		Bucket bucket = cluster.bucket(bucketName);
		bucket.waitUntilReady(Duration.ofSeconds(10));

		GetResult getResult = bucket.defaultCollection().get("phone_to_session::7738162078");


		System.out.println(getResult.toString());
		// Get a user-defined collection reference

		// Return the result rows with the rowsAsObject() method and print to the terminal.
		System.out.println("finished calltron call");
	}

}
