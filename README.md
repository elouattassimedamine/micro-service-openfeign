<h1>Architecture MICRO-SERVICE avec une communication synchrone "OPEN-FEIGN"</h1>
<p>Dans ce projet nous allons voir comment créer une architecture micro-service en reliant un micro service customer,inventory et billing</p>
<p>Pour reliées ses micros-services il va falloir configurer la gateway pour connaitre le chemin de chaque micro service et configurer le registre eureka server pour connaitre l'emplacement et le nom de chaque micro service</p>
<h2>La configuration de notre architecture</h2>
<img src="img/Capture.PNG">
<h3>Pour commencer on crée le premier micro service qui est CUSTOMER</h3>
<p>CUSTOMER est crée sous 4 couches la couches <ul><li>Entity</li><li>Repository</li><li>Service</li><li>Web</li></ul></p>
<img src="img/couche.PNG">
<h3>On crée le deuxième micro service qui est INVENTORY</h3>
<p>INVENTORY est crée sous 4 couches la couches <ul><li>Entity</li><li>Repository</li><li>Service</li><li>Web</li></ul></p>
<img src="img/couche.PNG">
<h3>On crée la gateway</h3>
<p>Il y a deux types de configuration de la gateway: <ul><li>Configuration statique</li><li>Configuration dynamique</li></ul></p>
<p>Dans cet exemple nous avons opté pour une configuration dynamique</p>
<img src="img/GATEWAY.PNG">
<h3>On crée le le registre eureka server</h3>
<p>le registre eureka server est configurer de la manièere suivante:</p>
<img src="img/EUREKA.png">
<p>Et dans chaque service "CUSTOMER, INVENTORY et la GATEWAY" on crée un ficher application.yml pour donner un nom à nos micros services</p>
<h5>Exemple:</h5>
<img src="img/ERUEKASERVER.png">
<p>Si on test la couche web de chaque micro service avec la gateway, on ecrit juste le nom du micro service configurer dans spring eureka et la gateway s'occupe de l'acheminement vers le service</p>
<img src="img/CUSTOMERGATEWAY.png">
<img src="img/INVENTORYGATEWAY.png">

<p style="color: red">la premier phase est complétée</p>
<h2>Création d'un troisième micro service "BILLING"</h2>
<p>Le service BILLING regroupe les information des deux autres micro service INVENTORY et CUSTOMER</p>
<p>Pour faire cela, on utilise le framework OPENFEIGN, pour faire cela </p>
<p>BILLING est crée sous 5 couches la couches <ul><li>Entity</li><li>Model</li><li>Repository</li><li>Service</li><li>Web</li></ul></p>
<p>Dans la couche model on crée deux classes inventory et customer et dans billing on sauvegarde juste les id des customers et des produits</p>
<p>Quand on veut afficher une facture on a juste a prendre l'id du customer et les id des produits et on les cherches dans les micros services "INVENTORY et CUSTOMER"</p>
<p>Pour faire cela: </p>
<img src="img/openfeign.png">
<h4>Quand on cherche une facture</h4>
<img src="img/billinggate1.png">
<img src="img/billinggate2.png">
<p>Comme on le voit dans les deux captures quand on affiche la facture avec l'id 1</p>
<p>BILLING va cherhcer les informations sur le customer son et email et cherche pour chaque id d'un produit son prix, son nom et la quantté dans le stock</p>