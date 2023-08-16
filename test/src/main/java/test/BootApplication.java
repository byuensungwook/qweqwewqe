package test;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing 		// BaseTime 자동으로 세팅
@ServletComponentScan 	//서블릿 자동 등록
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {

//    	SpringApplication.run(BootApplication.class, args);
        
        SpringApplication springApplication = new SpringApplication(BootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setLogStartupInfo(false);
        springApplication.run(args);
    }

}
