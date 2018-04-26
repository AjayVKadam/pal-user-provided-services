package io.pivotal.pal.paluserprovidedservices;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Log
@EnableTask
@SpringBootApplication
public class DemoTaskApplication {

    @Autowired
    DataSource dataSource;

    @Bean
    ApplicationRunner run() {

        return new MyTaskRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoTaskApplication.class, args);
    }

    class MyTaskRunner implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {
            JdbcTemplate jdbcTempLate = new JdbcTemplate(dataSource);

            String sql = "Update cohort set nickname = 'ajay.kadam' where name = 'Ajay' ";
            jdbcTempLate.execute(sql);

            sql = "Update cohort set nickname = 'mahanthi.bukkapatnam' where name = 'Mahanthi' ";
            jdbcTempLate.execute(sql);
        }
    }
}



