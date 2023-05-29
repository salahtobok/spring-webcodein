--
Generate self-sign certification
<pre>
keytool -genkey -alias webcodein-ks -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
    Enter keystore password: webcodein
    Re-enter new password: webcodein
    Enter the distinguished name. Provide a single dot (.) to leave a sub-component empty or press ENTER to use the default value in braces.
    What is your first and last name?
    [Unknown]:  Tobok SalahEddine
    What is the name of your organizational unit?
    [Unknown]:  wc
    What is the name of your organization?
    [Unknown]:  webcodein
    What is the name of your City or Locality?
    [Unknown]:  algiers
    What is the name of your State or Province?
    [Unknown]:  algiers
    What is the two-letter country code for this unit?
    [Unknown]:  dz
    Is CN=Tobok SalahEddine, OU=wc, O=webcodein, L=algiers, ST=algiers, C=dz correct?
    [no]:  yes
    
    Generating 2.048 bit RSA key pair and self-signed certificate (SHA384withRSA) with a validity of 3.650 days
    for: CN=Tobok SalahEddine, OU=wc, O=webcodein, L=algiers, ST=algiers, C=dz
</pre>
--
Keycloak : 
Login : salahtobok Password : root