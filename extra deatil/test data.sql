--- Product
INSERT INTO product (product_id, enabled, product_name) VALUES (nextval('product_seq'), 'Y', 'Send to Bank');
INSERT INTO product (product_id, enabled, product_name) VALUES (nextval('product_seq'), 'Y', 'Send to wallet');
INSERT INTO product (product_id, enabled, product_name) VALUES (nextval('product_seq'), 'Y', 'Cash pickup');
--- Country
INSERT INTO country (country_code, enabled, country_legacy_code, country_name) VALUES ('PAK', 'Y', 'PK', 'Pakistan');
INSERT INTO country (country_code, enabled, country_legacy_code, country_name) VALUES ('IND', 'Y', 'IN', 'India');
----City 
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Karachi', 'PAK');	       
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Lahore', 'PAK');   
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Faisalabad', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Rawalpindi', 'PAK');	   
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Gujranwala', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Peshawar', 'PAK');	       
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Multan', 'PAK');	   
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Hyderabad', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Islamabad', 'PAK');	       
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Quetta', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Bahawalpur', 'PAK');	   
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Sargodha', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Sialkot', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Sukkur', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Larkana', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Sheikhupura', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Rahim Yar Khan', 'PAK');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Jhang', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Dera Ghazi Khan', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Gujrat', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Sahiwal', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Wah Cantonment', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Mardan', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kasur', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Okara', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Mingora', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Nawabshah', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Chiniot', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kotri', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kāmoke', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Hafizabad', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Sadiqabad', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Mirpur Khas', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Burewala', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kohat', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Khanewal', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Dera Ismail Khan', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Turbat', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Muzaffargarh', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Abbotabad', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Mandi Bahauddin', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Shikarpur', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Jhelum', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Khanpur', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Khairpur', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Khuzdar', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Pakpattan', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Hub', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Daska', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Gojra', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Dadu', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Muridke', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Bahawalnagar', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Samundri', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Tando Allahyar', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Tando Adam', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Jaranwala', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Chishtian', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Muzaffarabad', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Attock', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Vehari', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kot Abdul Malik', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Ferozwala', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Chakwal', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Gujranwala Cant', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kamalia', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Umerkot', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Ahmedpur East', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kot Addu', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Wazirabad', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Mansehra', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Layyah', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Mirpur', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Swabi', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Chaman', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Taxila', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Nowshera', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Khushab', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Shahdadkot', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Mianwali', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Kabal', 'IND');
INSERT INTO city (city_id, enabled, city_name, country_code) VALUES (nextval('city_seq'), 'Y', 'Lodhran', 'IND');

-- wallet detail

INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Payoneer e-wallet', 'PAK');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Skrill e-wallet', 'PAK');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Neteller e-wallet', 'PAK');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Perfect Money e-Wallet', 'PAK');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Payeer e-wallet', 'PAK');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'CoinBase', 'PAK');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'WebMoney', 'PAK');

INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Paytm', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'MobiKwik', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Oxigen Wallet', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Citrus Wallet', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'ItzCash', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'FreeCharge', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Axis Bank Lime', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Airtel Money', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'ICICI Pockets', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Jio Money', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'mRupee', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'SBI Buddy', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Vodafone M-Pesa', 'IND');
INSERT INTO wallet (wallet_id, enabled, wallet_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'HDFC PayZapp', 'IND');

-- Bank
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'National Bank of Pakistan', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'First Women Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'The Bank of Khyber', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'The Bank of Punjab', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Sindh Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Zarai Tarqiati Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'SME Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Punjab Provincial Cooperative Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Industrial Development Bank of Pakistan Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Habib Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'United Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'MCB Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Allied Bank limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Bank Al-Falah Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Bank Al-Habib Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Habib Metropolitan Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'JS Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Faysal Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Askari Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Standard Chartered Bank (Pakistan) Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Soneri Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'SILKBANK Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Summit Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Samba Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Meezan Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Al-Baraka Bank (Pakistan) Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Bank Islami Pakistan Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'MCB Islamic Bank Limited', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Dubai Islamic Bank Pakistan', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Citi Bank N.A', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Deutsche Bank AG', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Industrial & Commercial Bank of China', 'PAK');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('wallet_seq'), 'Y', 'Bank of China Limited', 'PAK');


INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Allahabad Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Andhra Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank of Baroda', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank of India', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank of Maharashtra', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Canara Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Central Bank of India', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Corporation Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Dena Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Indian Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Indian Overseas Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Oriental Bank of Commerce', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Punjab & Sind Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Punjab National Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Syndicate Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'UCO Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Union Bank of India', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'United Bank Of India (UBI)', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Vijaya Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'IDBI Bank Limited', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'State Bank of India', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'State Bank Of Bikaner & Jaipur', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'State Bank of Hyderabad', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'State Bank of Mysore', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'State Bank of Patiala', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'State Bank of Travancore', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Catholic Syrian Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'City Union Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Dhanalakshmi Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Federal Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'ING Vysya Bank Ltd', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Jammu & Kashmir Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Karnataka Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Karur Vysya Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Lakshmi Vilas Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'The Ratnakar Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Nanital Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'SBI Commercial & International Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'South India Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Tamilnadu Mercantile Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'United Western Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'IndusInd Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'HDFC Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'ICICI Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Axis Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Kotak Mahindra Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Yes Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'ABN-AMRO Bank NV', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Amercian Express Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Abu Dhabi Commercial Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'ANZ Grindlays Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Arab Bangladesh Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank International Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank Muscat Saog', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank Of America NV', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank Of Bahrain & Kuwait BSC', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank Of Ceylon', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank Of Nova Scotia', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Bank Of Tokyo-Mitsubish', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Barclays Bank PLC', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'BNP Paribas', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'China Trust Commercial Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Cho Hung Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Citi Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Commerz Bank AG', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Credit Agricole Indosuez', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Credit Lyonnais', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Deutsche Bank AG', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Developmnt Bank Of Singapore', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'HSBC', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'ING Bank NV', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'KBC Bank NV', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Krung Thai Bank Public Co', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Mashreq Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Oversea-Chinese Banking Corporation', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'The Sanwa Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Societe Generale', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Sonali Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Standard Chartered Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'Standard Chartered Grindlays Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'State Bank Of Mauritius', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'The Sumitomo Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'The Chase Manhattan Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'The Fuji Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'The Sakura Bank', 'IND');
INSERT INTO bank (bank_id, enabled, bank_name, country_code) VALUES (nextval('bank_seq'), 'Y', 'The Toronto-Dominion Bank', 'IND');

-- Partner
INSERT INTO partner (partner_id, enabled, forex_margin_share, partner_category, partner_name, partner_share, partner_txt_id_label, preference_order, transfer_speed)
VALUES (nextval('partner_seq'), 'Y', 0.02, 'Preferential MTOs with opt out', 'Moneygram', 2.94, '15975365482', 1, 'Realtime');

INSERT INTO partner (partner_id, enabled, forex_margin_share, partner_category, partner_name, partner_share, partner_txt_id_label, preference_order, transfer_speed)
VALUES (nextval('partner_seq'), 'Y', 1.02, 'Preferential MTOs with opt out', 'Master Card', 3.94, '15975365485', 2, 'Not Realtie');

INSERT INTO partner (partner_id, enabled, forex_margin_share, partner_category, partner_name, partner_share, partner_txt_id_label, preference_order, transfer_speed)
VALUES (nextval('partner_seq'), 'Y', 2.02, 'Preferential MTOs without opt out', 'Western Union', 4.94, '159753644582', 3, 'Realtime');


--update partner set preference_order = (case when partner_id = 1000 then 2 when partner_id = 1001 then 3 when partner_id = 1002 then 1 end) where partner_id in (1000, 1001, 1002);

INSERT INTO partner_country (partner_id, country_code) VALUES (1000, 'PAK');
INSERT INTO partner_country (partner_id, country_code) VALUES (1000, 'IND');
INSERT INTO partner_country (partner_id, country_code) VALUES (1001, 'PAK');
INSERT INTO partner_country (partner_id, country_code) VALUES (1001, 'IND');
INSERT INTO partner_country (partner_id, country_code) VALUES (1002, 'PAK');
INSERT INTO partner_country (partner_id, country_code) VALUES (1002, 'IND');

INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1000);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1002);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1003);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1004);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1005);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1006);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1007);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1008);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1009);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1010);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1011);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1012);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1013);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1014);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1015);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1016);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1017);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1018);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1019);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1020);
INSERT INTO partner_city (partner_id, city_id) VALUES (1000, 1021);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1022);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1023);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1024);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1025);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1026);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1027);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1028);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1029);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1030);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1031);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1032);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1033);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1034);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1035);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1036);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1037);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1038);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1039);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1040);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1041);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1042);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1043);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1044);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1045);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1046);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1047);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1048);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1049);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1050);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1051);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1052);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1053);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1054);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1055);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1056);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1057);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1058);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1059);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1060);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1061);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1062);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1063);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1064);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1065);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1066);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1067);
INSERT INTO partner_city (partner_id, city_id) VALUES (1001, 1068);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1069);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1070);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1071);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1072);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1073);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1074);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1075);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1076);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1077);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1078);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1079);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1080);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1081);
INSERT INTO partner_city (partner_id, city_id) VALUES (1002, 1082);

INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1000, 1000);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1001, 1001);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1002, 1002);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1000, 1003);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1001, 1004);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1002, 1005);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1000, 1006);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1001, 1007);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1002, 1008);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1000, 1009);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1001, 1010);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1002, 1011);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1000, 1012);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1001, 1013);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1002, 1014);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1000, 1015);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1001, 1016);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1002, 1017);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1000, 1018);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1001, 1019);
INSERT INTO partner_wallet (partner_id, wallet_id) VALUES (1002, 1020);

INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1000);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1001);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1002);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1003);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1004);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1005);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1006);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1007);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1008);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1009);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1010);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1011);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1012);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1013);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1014);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1015);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1016);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1017);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1018);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1019);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1020);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1021);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1022);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1023);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1024);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1025);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1026);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1027);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1028);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1029);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1030);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1031);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1032);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1033);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1034);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1035);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1036);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1037);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1038);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1039);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1040);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1041);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1042);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1043);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1044);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1045);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1046);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1047);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1048);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1049);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1050);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1051);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1052);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1053);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1054);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1055);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1056);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1057);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1058);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1059);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1060);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1061);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1062);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1063);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1064);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1065);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1066);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1067);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1068);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1069);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1070);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1071);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1072);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1073);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1074);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1075);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1076);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1077);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1078);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1079);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1080);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1081);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1082);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1083);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1084);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1085);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1086);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1087);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1088);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1089);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1090);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1091);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1092);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1093);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1094);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1095);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1096);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1097);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1098);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1099);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1101);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1102);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1103);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1104);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1105);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1106);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1107);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1108);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1109);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1110);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1111);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1112);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1113);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1114);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1115);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1001, 1116);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1002, 1117);
INSERT INTO partner_bank (partner_id, bank_id) VALUES (1000, 1118);

INSERT INTO profile (profile_id, enabled, profile_name) VALUES (1000, 'Y', 'IMRH Master admin profile');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1000, 'Y', 'Global Partner');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1001, 'Y', 'Global Country');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1002, 'Y', 'Global City');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1003, 'Y', 'Global Bank');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1004, 'Y', 'Global Wallet');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1005, 'Y', 'Mto Partner');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1006, 'Y', 'Mto Country');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1007, 'Y', 'Mto City');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1008, 'Y', 'Mto Bank');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1009, 'Y', 'Mto Wallet');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1010, 'Y', 'Mto Partner Customer');
INSERT INTO permission (permission_id, enabled, permission_name) VALUES (1011, 'Y', 'Mto Partner Country Product');

INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1000, 'Y', 1000, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1001, 'Y', 1001, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1002, 'Y', 1002, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1003, 'Y', 1003, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1004, 'Y', 1004, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1005, 'Y', 1005, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1006, 'Y', 1006, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1007, 'Y', 1007, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1008, 'Y', 1008, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1009, 'Y', 1009, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1010, 'Y', 1010, 1000);
INSERT INTO profile_permission (profile_permission_id, enabled, permission_id, profile_id) VALUES (1011, 'Y', 1011, 1000);

--================1) All Product Report => Show (Name + Status + Image)=========
SELECT product_id, product_name,
CASE
    WHEN enabled = 'Y' THEN 'Enabled'
    WHEN enabled = 'N' THEN 'Disable'
END AS status, product_image_url
FROM product;
--================2) All Country Report => Show (Name + Status + Image) => Count Report (City, Wallet, Bank)=========
CREATE VIEW fetch_All_Global_Country_Detail_For_Report_Query AS
    SELECT country.country_name, country.country_code,
    CASE
        WHEN country.enabled = 'Y' THEN 'Enabled'
        WHEN country.enabled = 'N' THEN 'Disable'
    END AS status, country.country_image_url,
    COALESCE(city.total_city, 0) AS total_city,
    COALESCE(wallet.total_wallet, 0) AS total_wallet,
    COALESCE(bank.total_bank, 0) AS total_bank
    FROM country
    LEFT JOIN (
         SELECT country_code, COUNT(*) AS total_city FROM city GROUP BY country_code) city
    ON city.country_code = country.country_code
    LEFT JOIN (
         SELECT country_code, COUNT(*) AS total_wallet FROM wallet GROUP BY country_code) wallet
    ON wallet.country_code = country.country_code
    LEFT JOIN (
         SELECT country_code, COUNT(*) AS total_bank FROM bank GROUP BY country_code) bank
    ON bank.country_code = country.country_code
    ORDER BY country.country_name ASC;

SELECT * FROM fetch_All_Global_Country_Detail_For_Report_Query;
--- Query call only when count is more then '0' and display as table on report
-- fetch city table
SELECT city_id, city_name,
CASE
    WHEN enabled = 'Y' THEN 'Enabled'
    WHEN enabled = 'N' THEN 'Disable'
END AS status
FROM city WHERE country_code = 'PAK';
-- fetch wallet table
SELECT wallet_id, wallet_name,
CASE
    WHEN enabled = 'Y' THEN 'Enabled'
    WHEN enabled = 'N' THEN 'Disable'
END AS status
FROM wallet WHERE country_code = 'PAK';
-- fetch bank table
SELECT bank_id, bank_name,
CASE
    WHEN enabled = 'Y' THEN 'Enabled'
    WHEN enabled = 'N' THEN 'Disable'
END AS status
FROM bank WHERE country_code = 'PAK';
--================3) Single Country Report => Show (Name + Status + Image) => Count Report (City, Wallet, Bank) => Display List (City, Wallet, Bank)=========
SELECT * FROM fetch_All_Global_Country_Detail_For_Report_Query;
WHERE country_code = 'IND';
--- Query call only when count is more then '0' and display as table on report
-- fetch city table -> use old, fetch wallet table -> use old, fetch bank table -> use old

--================4) All Mto Partner Report => Show (Partner Detail) => Count Report (City, Wallet, Bank) => Display List (City, Wallet, Bank)=========
SELECT partner.partner_id, partner.partner_name, partner.transfer_speed, partner.partner_image_url FROM partner;
-- for mto partner fetch the country
CREATE VIEW fetch_Mto_Partner_Country_View AS
    SELECT partner.partner_id, partner.partner_name, country.country_name FROM partner
    INNER JOIN partner_country ON partner_country.partner_id = partner.partner_id
    INNER JOIN country ON country.country_code = partner_country.country_code;
-- for mto partner fetch the city
CREATE VIEW fetch_Mto_Partner_Country_City_View AS
SELECT partner.partner_id, partner.partner_name, partner.partner_image_url,
country.country_code, country.country_name, country.country_image_url,
city.city_id, city.city_name,
CASE
    WHEN city.enabled = 'Y' THEN 'Enabled'
    WHEN city.enabled = 'N' THEN 'Disable'
END AS status
FROM partner
INNER JOIN partner_city ON partner_city.partner_id = partner.partner_id
INNER JOIN city ON city.city_id = partner_city.city_id
INNER JOIN country ON country.country_code = city.country_code;
-- for mto partner fetch the bank
CREATE VIEW fetch_Mto_Partner_Country_Bank_View AS
SELECT partner.partner_id, partner.partner_name, partner.partner_image_url,
country.country_code, country.country_name, country.country_image_url,
bank.bank_id, bank.bank_name, bank.bank_image_url,
CASE
    WHEN bank.enabled = 'Y' THEN 'Enabled'
    WHEN bank.enabled = 'N' THEN 'Disable'
END AS status
FROM partner
INNER JOIN partner_bank ON partner_bank.partner_id = partner.partner_id
INNER JOIN bank ON bank.bank_id = partner_bank.bank_id
INNER JOIN country ON country.country_code = bank.country_code;
-- for mto partner fetch the wallet
CREATE VIEW fetch_Mto_Partner_Country_Wallet_View AS
SELECT partner.partner_id, partner.partner_name, partner.partner_image_url,
country.country_code, country.country_name, country.country_image_url,
wallet.wallet_id, wallet.wallet_name, wallet.wallet_image_url,
CASE
    WHEN wallet.enabled = 'Y' THEN 'Enabled'
    WHEN wallet.enabled = 'N' THEN 'Disable'
END AS bank_enabled
FROM partner
INNER JOIN partner_wallet ON partner_wallet.partner_id = partner.partner_id
INNER JOIN wallet ON wallet.wallet_id = partner_wallet.wallet_id
INNER JOIN country ON country.country_code = wallet.country_code;
-- for profile-permission to check the permission
CREATE VIEW PROFILE_PERMISSIONS_VIEW AS
SELECT PROFILE_PERMISSION.PROFILE_PERMISSION_ID, PROFILE_PERMISSION.PROFILE_ID, PROFILE.PROFILE_NAME, PROFILE_PERMISSION.PERMISSION_ID, PERMISSION.PERMISSION_NAME
FROM PROFILE_PERMISSION
INNER JOIN PROFILE ON PROFILE.PROFILE_ID = PROFILE_PERMISSION.PROFILE_ID
INNER JOIN PERMISSION ON PERMISSION.PERMISSION_ID = PROFILE_PERMISSION.PERMISSION_ID;

--
SELECT setval('partner_customer_seq', 42000, true);