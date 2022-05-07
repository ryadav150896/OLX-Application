package com.zensar.olxapplication.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	//to support for Actuator here we commented that  swagger
	
	/*@Bean
	public Docket getCustomizeDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.zensar.olxapplication")).build()
				.apiInfo(getInfo());
	}

	private ApiInfo getInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("OLX  Application", "This Application manages Userlogin and UserInformation", "2.0.0", "http://www.zensar.com", "Ravi", "apache", "https://www.apache.org/licenses/LICENSE-2.0.txt");
	}*/
}
