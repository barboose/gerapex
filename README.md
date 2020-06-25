## About project
This is a sample Spring Boot (2.3.1) project which introduce how to create easily generic RESTful endpoints

### Snippet
```
@RestController
public class OrderController<ItemType extends Item, Request extends Order<ItemType> & ApiRequest> implements Serializable
{
	private final OrderService<ItemType> service;
	...
}
```

### How to run
`mvn spring-boot:run`
