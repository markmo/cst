package io.metamorphic.cst.services;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.query.Select;
import com.couchbase.client.java.query.dsl.Expression;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by markmo on 17/07/2015.
 */
@Service
public class CouchbaseService implements InitializingBean, DisposableBean {

    private static final Log log = LogFactory.getLog(CouchbaseService.class);

    private Cluster cluster;
    private Bucket defaultBucket;

    @Override
    public void afterPropertiesSet() throws Exception {
        cluster = CouchbaseCluster.create();
        defaultBucket = cluster.openBucket();
        if (log.isDebugEnabled()) {
            log.debug("Created cluster and `default` bucket");
        }
    }

    @Override
    public void destroy() throws Exception {
        cluster.disconnect();
        defaultBucket.close();
        if (log.isDebugEnabled()) {
            log.debug("Disconnected from cluster and closed `default` bucket");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> events(String customerId) {
        if (log.isDebugEnabled()) {
            log.debug(this.getClass().getSimpleName() + ".events called with customer ID: " + customerId);
        }
        List<Map<String, Object>> results = new ArrayList<>();
        N1qlQueryResult query = defaultBucket.query(
                Select.select("events")
                        .from("default")
                        .where(Expression.x("id").eq(Expression.s(customerId)))
        );
        Iterator<N1qlQueryRow> rows = query.rows();
        while (rows.hasNext()) {
            N1qlQueryRow row = rows.next();
            JsonObject value = row.value();
            if (value.containsKey("events")) {
                JsonArray events = value.getArray("events");
                for (Object obj : events.toList()) {
                    results.add((Map) obj);
                }
            }
        }
        return results;
    }
}
