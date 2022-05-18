Notes for learning Gson.

- [Basic Usage](#basic-usage)
- [GsonBuilder](#gsonbuilder)
- [Filed Name Strategy](#filed-name-strategy)
- [Conditional Change filed name](#conditional-change-filed-name)
- [@Since](#since)

#### Basic Usage



```java
public static void main(String[] args) {
        Customer customer = new Customer(1, "johnd", "john@gmail.com", "m38rmF$", "1-570-236-7033", new Date());

        System.out.println(toJson(customer));
    }

    public static Gson gson = new Gson();

    public static String toJson(Customer customer) {
        return gson.toJson(customer);
    }

    public static Customer fromJson(String json) {
        return gson.fromJson(json, Customer.class);
    }
```
```json
{"id":1,"username":"johnd","email":"john@gmail.com","password":"m38rmF$","phoneNumber":"1-570-236-7033","createdAt":"May 18, 2022 3:49:28 AM"}
```

#### GsonBuilder

```java
public class App {
    public static void main(String[] args) {
        Customer customer = new Customer(1, "johnd", "john@gmail.com", "m38rmF$", "1-570-236-7033", new Date());

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();

        gsonBuilder.setDateFormat("dd-MM-yyyy");

        Gson gson = gsonBuilder.create();

    }

    public static Gson gson = new Gson();

    public static String toJson(Customer customer) {
        return gson.toJson(customer);
    }

    public static Customer fromJson(String json) {
        return gson.fromJson(json, Customer.class);
    }
}
```

```json
{
  "id": 1,
  "username": "johnd",
  "email": "john@gmail.com",
  "password": "m38rmF$",
  "phoneNumber": "1-570-236-7033",
  "createdAt": "18-05-2022"
}
```

#### Filed Name Strategy

```java

gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
    @Override
    public String translateName(Field f) {
       if (f.getName().equals("id")) {
           return "customerId";
        }});
```
```json
{
  "ID": 1,
  "USERNAME": "johnd",
  "EMAIL": "john@gmail.com",
  "PASSWORD": "m38rmF$",
  "PHONENUMBER": "1-570-236-7033",
  "CREATEDAT": "18-05-2022"
}
```

```java
 gsonBuilder.setFieldNamingStrategy(FieldNamingPolicy.UPPER_CAMEL_CASE);
```

#### Conditional Change filed name

```java
```java
 gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                return f.getName().equals("id") ? "customerId" : f.getName();
            }
        });
```
```json
{
  "customerId": 1,
  "username": "johnd",
  "email": "john@gmail.com",
  "password": "m38rmF$",
  "phoneNumber": "1-570-236-7033",
  "createdAt": "18-05-2022"
}
```

#### @Since
```java
public class Customer {
    @Since(1.0)
    private Integer id;

    @Since(1.0)
    private String username;

    @Since(1.0)
    private String email;

    @Since(1.0)
    private String password;

    @Since(1.0)
    private String phoneNumber;

    @Since(1.1)
    private Date createdAt;

}

 gsonBuilder.setVersion(1.0);
```    
```json
{
  "customerId": 1,
  "username": "johnd",
  "email": "john@gmail.com",
  "password": "m38rmF$",
  "phoneNumber": "1-570-236-7033"
  // exclude createdAt
}
```
