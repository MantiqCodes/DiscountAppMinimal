                                            Discount App 

In order to generate test coverage (using EclEmma), 

From Eclipse Spring Tools Suit:
1.Right click on project root 
2. Choose Coverage As 
3. Choose JUnit Test
4. Open Coverage window :
   click Window => Show View => other..=> Java=>Coverage
  
![Alt CodeCovrage](CodeCoverage.png?raw=true "Coverage")


From Terminal:
1. Open a terminal 
2. cd to project root "DiscountSystemMinimal"
3. and run :
    mvn verify

 4 . visit file:///<PATH_TO_PROJECT_PARENT_FOLDER>/DiscountSystemMinimal/target/site/jacoco/index.html 

![Alt CodeCovrage](Jacoco.png?raw=true "Jacoco")




How to run the project: 

1. Open a terminal 
2. cd to project root "DiscountSystemMinimal"
3. and run :
    mvn spring-boot:run 

I used Swagger for documentaton. 
For documentation visit the url 
http://localhost:9191/swagger-ui.html



Examples: 

 Please note that : 
            The value of customerType can only be the following which are case sensitive:
            
            Employee , Affiliate or Customer .

            The value of memberShipAgeInDays can be any integer, but for effective discount it has to be more  
             than 2 years which is 730 days. An effective figure for this parameter is 731 . 

           The value of nonGroceryItemTotal can be any double value .


Case:1 
A new Customer spends $990 for non-grocery items. His discount is $45;

http://localhost:9191/getDiscount?customerType=Customer&memberShipAgeInDays=0&nonGroceryItemTotal=990

Case 2:
 A customer's membership age is more than 2 years ( 731 days) , he will get 5% discount on his non-grocery purchages. For example if he purchages $99 for non-grocery items his discount amount is $4.95

http://localhost:9191/getDiscount?customerType=Customer&memberShipAgeInDays=732&nonGroceryItemTotal=99  


caser 3:
 A customer is an employee . He purchases $990 worth of non-grocery items. His discount is 30% which is $297

http://localhost:9191/getDiscount?customerType=Employee&memberShipAgeInDays=0&nonGroceryItemTotal=990


case:4
A customer is an affiliate.  He purchases $990 worth of non-grocery items. His discount is 10% which is $99

http://localhost:9191/getDiscount?customerType=Affiliate&memberShipAgeInDays=0&nonGroceryItemTotal=990


![Alt DiscountApp](DiscountAppMinimal.png?raw=true "DiscountAppMinimal")


