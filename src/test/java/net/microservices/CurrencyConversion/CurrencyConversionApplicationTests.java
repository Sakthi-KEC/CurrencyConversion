package net.microservices.CurrencyConversion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyConversionApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//		private WebTestClient webTestClient;
//		@MockBean
//		private CurrencyConversionService service;
//
//		@Test
//		public void addProductTest() {
//			Mono<CurrencyConversionDto> productDtoMono = Mono.just(new CurrencyConversionDto( "USD", "ads", 1, true, "JKR","12-08-2021",true));
//			when(service.saveCurrencyData(productDtoMono)).thenReturn(productDtoMono);
//
//			webTestClient.post().uri("/currencyconversion")
//					.body(Mono.just(productDtoMono), CurrencyConversionDto.class)
//					.exchange()
//					.expectStatus().isOk();//200
//		}
//
//	@Test
//	public void getProductsTest(){
//		Flux<CurrencyConversionDto> productDtoFlux=Flux.just(new CurrencyConversionDto("USD", "ads", 1, true, "JKR","12-08-2021",true));
//
//		when(service.getAllCurrencyDatas()).thenReturn(productDtoFlux);
//
//		Flux<CurrencyConversionDto> responseBody = webTestClient.get().uri("/currencyconversion")
//				.exchange()
//				.expectStatus().isOk()
//				.returnResult(CurrencyConversionDto.class)
//				.getResponseBody();
//
//		StepVerifier.create(responseBody)
//				.expectSubscription()
//				.expectNext(new CurrencyConversionDto( "USD", "ads", 1, true, "JKR","12-08-2021",true))
//
//				.verifyComplete();
//
//	}
//	@Test
//	public void getProductTest()  {
//		Mono<CurrencyConversionDto> productDtoMono=Mono.just(new CurrencyConversionDto( "USD", "ads", 1, true, "JKR","12-08-2021",true));
//		when(service.getCurrencyDataByCode(any())).thenReturn(productDtoMono);
//
//		Flux<CurrencyConversionDto> responseBody = webTestClient.get().uri("/currencyconversion/conversionkey/USD")
//				.exchange()
//				.expectStatus().isOk()
//				.returnResult(CurrencyConversionDto.class)
//				.getResponseBody();
//
//		StepVerifier.create(responseBody)
//				.expectSubscription()
//				.expectNextMatches(p->p.getConversionKey().equals("USD"))
//				.verifyComplete();
//	}
//	@Test
//	public void getNameTest()  {
//		Flux<CurrencyConversionDto> productDtoMono=Flux.just(new CurrencyConversionDto( "USD", "INR", 1, true, "JKR","12-08-2021",true));
//		when(service.getCurrencyDataByName(any())).thenReturn(productDtoMono);
//
//		Flux<CurrencyConversionDto> responseBody = webTestClient.get().uri("/currencyconversion/name/INR")
//				.exchange()
//				.expectStatus().isOk()
//				.returnResult(CurrencyConversionDto.class)
//				.getResponseBody();
//
//		StepVerifier.create(responseBody)
//				.expectSubscription()
//				.expectNextMatches(p->p.getConversionName().equals("INR"))
//				.verifyComplete();
//	}
//
//	@Test
//	public void getCreatedByTest()  {
//		Flux<CurrencyConversionDto> productDtoMono=Flux.just(new CurrencyConversionDto( "USD", "ads", 1, true, "JKR","12-08-2021",true));
//		when(service.getCurrencyDataByCreatedBy(any())).thenReturn(productDtoMono);
//
//		Flux<CurrencyConversionDto> responseBody = webTestClient.get().uri("/currencyconversion/createdby/JKR")
//				.exchange()
//				.expectStatus().isOk()
//				.returnResult(CurrencyConversionDto.class)
//				.getResponseBody();
//
//		StepVerifier.create(responseBody)
//				.expectSubscription()
//				.expectNextMatches(p->p.getCreatedBy().equals("JKR"))
//				.verifyComplete();
//	}
//
////	@Test
////    public void dynamicTest(){
////        Flux<CurrencyConversionDto> productDtoFlux=Flux.just(new CurrencyConversionDto("USD", "ads", 1, true, "JKR","12-08-2021",true));
////
////        //when(service.getByProp("USD","ads",6,true,null,null)).thenReturn(productDtoFlux);
////
////        Flux<CurrencyConversionDto> responseBody = webTestClient.get().uri("/currencyconversion/customrepo?conversionName=ads")
////                .exchange()
////                .expectStatus().isOk()
////                .returnResult(CurrencyConversionDto.class)
////                .getResponseBody();
////
////        StepVerifier.create(responseBody)
////                .expectSubscription()
////                //.expectNext(new CurrencyConversionDto( "USD", "ads", 1, true, "JKR","12-08-2021",true))
////                .expectNextMatches(p->p.getConversionName().equals("ads"))
////                .verifyComplete();
////
////    }
//
//	@Test
//	public void addSavedProductTest() {
//		Mono<CurrencyConversionDto> productDtoMono = Mono.just(new CurrencyConversionDto( "USD", "ads", 1, true, "JKR","12-08-2021",true));
//		when(service.addsearchedcurrency(productDtoMono)).thenReturn(productDtoMono);
//
//		webTestClient.put().uri("/currencyconversion/savedsearch")
//				.body(Mono.just(productDtoMono), CurrencyConversionDto.class)
//				.exchange()
//				.expectStatus().isOk();//200
//	}
//	@Test
//	public void getSavedSearchTest(){
//		Flux<CurrencyConversionDto> productDtoFlux=Flux.just(new CurrencyConversionDto("USD", "ads", 1, true, "JKR","12-08-2021",true));
//		when(service.getCurrencyConversionByName(any())).thenReturn(productDtoFlux);
//
//		Flux<CurrencyConversionDto> responseBody = webTestClient.get().uri("/currencyconversion/savedsearch")
//				.exchange()
//				.expectStatus().isOk()
//				.returnResult(CurrencyConversionDto.class)
//				.getResponseBody();
//
//		StepVerifier.create(responseBody)
//				.expectSubscription()
//				.expectNextMatches(p->p.getConversionName().equals("ads"))
//				.verifyComplete();
//
//	}
}
