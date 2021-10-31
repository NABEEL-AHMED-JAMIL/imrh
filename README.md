# IMRH
This project is demo for setting the (IMRH) International Money Remittance Application. There is also app part base on ionic.<br>
Purpose of the project is use the simple crud with ionic and different tech such as (Redis cache, Red Hat Openshift Container Clusters) for RND.

## Application Design


## Database design.
Database design make application faster in development. For a database, we are using postgres database to store the data.
![alt text](extra deatil/db detail.png)

## Reporting.
For reporting imrh using JasperReports. Imrh reports name mention below.
1) All Product Report => Show (Name + Status + Image) <!--Report use on the product page-->
   ```
   SELECT product_id, product_name,
    CASE
        WHEN enabled = 'Y' THEN 'Enabled'
        WHEN enabled = 'N' THEN 'Disable'
    END, product_image_url FROM product;
   ```
3) All Country Report => Show (Name + Status + Image) => Count Report (City, Wallet, Bank) <!--Report use on the country page-->
4) Single Country Report => Show (Name + Status + Image) => Count Report (City, Wallet, Bank) => Display List (City, Wallet, Bank)  <!--Report use on the city,wallet,bank page-->
5) All Mto Partner Report => Show (Partner Detail) => Count Report (City, Wallet, Bank) => Display List (City, Wallet, Bank)
6) Single Mto Partner Report => Show (Partner Detail) => Count Report (City, Wallet, Bank) => Display List (City, Wallet, Bank)
7) All Partner Customer Report => Show (Partner Detail) => Count Report (Customer) => Display List (Customer)
8) All Partner Customer Report => Show (Partner Detail) => Count Report (Customer) => Display List (Customer)


## Openshift Container flow
