package test.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.RequiredArgsConstructor;

@EnableTransactionManagement
@Configuration
@RequiredArgsConstructor
public class DBConfig {
    /**
     * application.yml 설정으로 자동등록되는 datasource
     */
    private final DataSource datasource;

    //private final EntityManagerFactory entityManagerFactory;

    @Bean
    public PlatformTransactionManager transactionManager(){
        return new DataSourceTransactionManager(datasource);
        /**
         * DataSourceTransactionManager 는 JDBC를 사용하는 경우 주로 사용하며
         * JPA 를 이용한 Transction 처리 는 하단 을 쓴다고 검색하니 나옴
         * 하지만 DataSourceTransactionManager 써도 지금까지는 JPA 에서 적용이 잘됬음..
         * 업무를 하며 테스트 하다 수정필요시 변경해야 할듯
         *  */
        //return new JpaTransactionManager(entityManagerFactory);
    }
}
