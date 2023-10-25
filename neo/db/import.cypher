match ()-[r:Dummyrelatie]->() delete r;
match (k:Klant) delete k;
match (d: Dummy) delete d;

create (d:Dummy { message: "hello world" });

load csv with headers from 'file:///klant.csv' as line
    match (d:Dummy)
    create (k:Klant { nr: line.klantnr, naam: line.naam, straat: line.adres, plaats: line.plaats  })
    merge (k)-[:Dummyrelatie {message: "kijk een non-relationele-relatie!"}]->(d);


//En dan in een los schermpje
match (p:Klant) -[r]->(d)
return p,r,d;
