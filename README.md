# 🎥 *AKTOREAK ETA PELIKULAK KUDEATU* 🔧
>Datu-Egiturak eta Algoritmoak ikasgaieko proiektua aktore eta pelikulen kudeaketa egitea da.

Ikasgai honetan, garrantzitsua da programaren kostua. Horretarako, hasiera-hasieratik azpimarratu dugu zer den kostua eta nola zeregin berdin baterako hainbat inplementazio ezberdin dagoen.

Beraz, hau argi ikusteko, hainbat eginkizun bete beharko ditugu lauhilabetean zehar.

## Lehen eginkizuna

Lehen eginkizunean, aktore-kopuru handia eta beraien pelikulak kudeatuko dituen aplikazioa sortu beharko dugu. Honetarako, ezagunak ditugun *ArrayList*-ak eta berria den *HashMap* egitura erabiliko ditugu.

Aplikazio honek hainbat ekintza bideratuko ditu: Adibidez, pelikula baten aktore guztiak lortu (ala alderantziz, aktore baten pelikula guztiak), aktoreak gehitu ala kendu edota pelikula baten aurrekontua gehitu

Sei klase izango ditugu: Alde batetik, *Aktore* eta *Pelikula* klaseek elementu bakarra gordeko dute. Beste aldetik, *ListaAktore* eta *ListaPelikulak* klaseak bi *HashMap* izango dira, non datu guztiak bilduko diren. Azkenik, *ArrayAktore* eta *ArrayPelikulak* klaseak erabilgarriak izango dira inplementazioan - aurreko paragrafoan azaldutako hasierako bi ekintzetan, adibidez.

## Bigarren eginkizuna

Bigarren eginkizunean, datu egitura berri bat ikasi eta inplementatuko dugu: *DoubleLinkedList*.

Laborategi honek bi helburu nagusi dituela esan daiteke. Lehenik eta behin, lista estekatuak ondo inplementatzen ikastea da. Bestalde, lista hauek aurreko laborategiko *ArrayList*-engatik ordezkatzea.

Programa honek hainbat ekintza bideratuko ditu: Lista estekatu batean elementuak era ordenatuan txertatzea, elementuak bai hasiera eta bai amaieran txertatzea, elementu baten bilaketa, etab.

Printzipioz, hiru klase izango ditugu; *DoubleLinkedList*, *UnorderedDoubleLinkedList* eta *OrderedDoubleLinkedList*. Baina, lehen esan den bezala, lista estekatu hauek aurreko laborategiko lista bat edo gehiagotan ordezkatu beharko ditugu. Honen ondorioz, aldatutako klaseak jarri beharko ditugu. Gure kasuan, *ArrayPelikulak* eta *ArrayAktoreak* izan dira. Guztira 5 klase izango ditugu.

## Hirugarren eginkizuna

Hirugarren eginkizunean, aktore eta pelikulen arteko loturak aztertuko ditugu.

Horretarako, grafoak erabiliko ditugu, guk sortutako *GraphHash* izeneko datu-egitura inplementatuz. Aldi berean, bi aktore erlazionatuta badauden esango digun programa bat garatuko dugu, bai egia ala gezurra den edo aktore batetik besterako lotura nolakoa den esango diguna.

## Laugarren eginkizuna

Laugarren eginkizunean, aktore eta pelikula bakoitzeko *PageRank* balioekin lan egingo dugu.

*PageRank* bilaketa-tresna batek indexatutako dokumentuen (edo web orrialdeen) garrantziari balioa emateko erabiltzen den algoritmo sorta da. Eginkizun honetarako bi ataza ditugu. Hasteko, *PageRank* guztien kalkulua egitea da beharrezkoa. Ondoren, aktore edo pelikula baten izena emanda, bere pelikula edo aktore zerrenda, hurrenez hurren, inprimatuko du. Zerrenda hura ordenatuta egongo da, *PageRank*-aren arabera.

>Gure (4.) praktikaren *main* metodoa *PraktikaHasieratu* klasean dago. Hala ere, interaktiboa den *main* bat jarri dugu (*Main_Interaktiboa* klasean), non lehen, hirugarren eta laugarren eginkizunen atazak dauden, egiazko kudeaketa programa bat balitz bezala.
