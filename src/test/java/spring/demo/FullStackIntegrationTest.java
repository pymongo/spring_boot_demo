package spring.demo;

import java.net.URL;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FullStackIntegrationTest {

  @LocalServerPort
  private int port;

  private URL base;

  @Autowired
  private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port);
  }

  @Test
  public void getHello() throws Exception {
    ResponseEntity<String> response = template.getForEntity(base.toString(),
      String.class);
    System.out.println(response);
    System.out.println(response.getBody());
    // TODO 打log看看response是什么
    Assertions.assertThat(response.getBody()).isEqualTo("Index");
    // 下面是spring官方错误的代码样例 https://spring.io/guides/gs/spring-boot#_add_unit_tests
//    Assertions.assertThat(response.getBody().equals("Index"));
  }
}
