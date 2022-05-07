package com.zensar.olxadvertiseapplication.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	
	// to support actuator commenting this swagger
	
	/*@Bean
	public Docket getCustomizeDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.zensar.olxadvertiseapplication")).build()
				.apiInfo(getInfo());
	}

	private ApiInfo getInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("OLX Advertisement Application", "This Application manages Olx Advertisement", "2.0.0", "http://www.zensar.com", "Ravi", "apache", "https://www.apache.org/licenses/LICENSE-2.0.txt");
	}
	*/
}
