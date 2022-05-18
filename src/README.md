Notes for learning Gson.

- [Basic Usage](#basic-usage)
- [GsonBuilder](#gsonbuilder)
- [Filed Name Strategy](#filed-name-strategy)
- [Conditional Change filed name(Filed is the name of the class)](#conditional-change-filed-namefiled-is-the-name-of-the-class)
- [@Since (version filter)](#since-version-filter)
- [Serielize Nulls](#serielize-nulls)
- [Read from file.json](#read-from-filejson)
- [Exclude fields](#exclude-fields)
- [List to Json](#list-to-json)
- [JsonObject](#jsonobject)

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

#### Conditional Change filed name(Filed is the name of the class)

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

#### @Since (version filter)
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

#### Serielize Nulls
```java
 // serialize null
gsonBuilder.serializeNulls();
Customer customer = new Customer();
```
```json
{
  "customerId": null,
  "username": null,
  "email": null,
  "password": null,
  "phoneNumber": null,
  "createdAt": null
}
```

#### Read from file.json
```java
 try {
    File file = new File("src/main/resources/users.json");
    FileReader reader = new FileReader(file);
    gson = new Gson();
    Customer[] customers = gson.fromJson(reader, Customer[].class);

    for (Customer c : customers) {
        System.out.println(c);
    }
} catch (Exception e) {
    e.printStackTrace();
}
```
```
Customer(id=1, username=johnd, email=john@gmail.com, password=m38rmF$, phoneNumber=null, createdAt=null)
Customer(id=2, username=mor_2314, email=morrison@gmail.com, password=83r5^_, phoneNumber=null, createdAt=null)
Customer(id=3, username=kevinryan, email=kevin@gmail.com, password=kev02937@, phoneNumber=null, createdAt=null)
Customer(id=4, username=donero, email=don@gmail.com, password=ewedon, phoneNumber=null, createdAt=null)
Customer(id=5, username=derek, email=derek@gmail.com, password=jklg*_56, phoneNumber=null, createdAt=null)
Customer(id=6, username=david_r, email=david_r@gmail.com, password=3478*#54, phoneNumber=null, createdAt=null)
Customer(id=7, username=snyder, email=miriam@gmail.com, password=f238&@*$, phoneNumber=null, createdAt=null)
Customer(id=8, username=hopkins, email=william@gmail.com, password=William56$hj, phoneNumber=null, createdAt=null)
Customer(id=9, username=kate_h, email=kate@gmail.com, password=kfejk@*_, phoneNumber=null, createdAt=null)
Customer(id=10, username=jimmie_k, email=jimmie@gmail.com, password=klein*#%*, phoneNumber=null, createdAt=null)
```

#### Exclude fields
```java
try {
            File file = new File("backend/src/main/resources/data/users.json");
            FileReader fileReader = new FileReader(file);

            ExclusionStrategy strategy = new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return f.getName().equals("id");
                }

                @Override
                public boolean shouldSkipClass(java.lang.Class<?> clazz) {
                    return false;
                }
            };

            GsonBuilder gsonBuilder = new GsonBuilder()
                    .addDeserializationExclusionStrategy(strategy);
            
            Gson gson = gsonBuilder.create();

            Customer[] customers = gson.fromJson(fileReader, Customer[].class);
            for (Customer c : customers) {
                System.out.println(c);
                // session.save(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
```

#### List to Json
```java
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        // get all customers
        List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();

        

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        String json = gson.toJson(customers);

        System.out.println(json);

        session.close();
        sessionFactory.close();
```

#### JsonObject
```java
try {
            JsonObject obj = new JsonObject();
            obj.addProperty("id", 101);
            obj.addProperty("username", "seaboyz");
            obj.addProperty("password", "123456");
            obj.addProperty("email", "example@example.com");

            GsonBuilder builder = new GsonBuilder();

            builder.setPrettyPrinting();

            Gson gson = builder.create();

            String json = gson.toJson(obj);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
```
