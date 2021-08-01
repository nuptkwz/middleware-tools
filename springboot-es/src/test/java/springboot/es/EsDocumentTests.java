package springboot.es;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.es.pojo.User;

import java.io.IOException;

/**
 * es 7.6.x 文档 api讲解和学习
 */

@SpringBootTest
@Slf4j
class EsDocumentTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    //测试添加文档
    @Test
    void testAddDocument() throws IOException {
        //1.创建对象
        User user = new User("刻威舟", 27);
        //2.创建请求
        IndexRequest indexRequest = new IndexRequest("kwz_index");
        //put /kwz_index/_doc/1
        indexRequest.id("1");
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
        //将数据放入请求的JSON
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);

        //发送请求,获取结果
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());
    }

    //测试文档是否存在, get /index/doc/1
    @Test
    void testDocumentExists() throws IOException {
        GetRequest getRequest = new GetRequest("kwz_index", "1");
        //不获取返回的_source上下文了
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("kwz_index", "1");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());
    }

    //获取文档信息
    @Test
    void deleteDocument() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("kwz_index");
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
        System.out.println(delete.toString());
    }

    //更新文档信息
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("kwz_index", "1");
        updateRequest.timeout("1s");
        //添加更新结构体
        User user = new User("令狐冲", 28);
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);

        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse.status());
        System.out.println(updateResponse);
    }

    @Test
    void testDeleteRequest() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("kwz_index", "1");
        deleteRequest.timeout("1s");

        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status());
    }

    //批量导入数据
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        int age = 10;
        //批处理请求
        for (int i = 0; i < 5; i++) {
            User currentUser = new User("name" + i, age + i);
            bulkRequest.add(
                    new IndexRequest("kwz_index").id("" + (i + 1)).source(JSON.toJSONString(currentUser), XContentType.JSON)
            );
        }

        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.status());
        System.out.println(bulkResponse.hasFailures());
    }
}
