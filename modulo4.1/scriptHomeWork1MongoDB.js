
db.createCollection("animal")

db.animal.insert({
  "id_animal" : 1,
		"id_cliente" : 1,
		"nome" : "Smith",
		"tipo" : "Cachorro",
		"raca" : "Pitbull",
		"pelagem" : "Curto",
		"porte" : "Medio",
		"idade" : 5
})
{ acknowledged: true,
  insertedIds: { '0': ObjectId("62eb00b8eb3531cb483e5e0c") } }

db.animal.insert({
  "id_animal" : 2,
		"id_cliente" : 2,
		"nome" : "Renatin pilantra",
		"tipo" : "Cachorro",
		"raca" : "Doberman",
		"pelagem" : "Curto",
		"porte" : "Grande",
		"idade" : 2
})
{ acknowledged: true,
  insertedIds: { '0': ObjectId("62eb00daeb3531cb483e5e0d") } }

db.animal.find({
    "animal.nome" : "Renatin pilantra",
    })
db.animal.find({ 
	  "nome" : "Renatin pilantra"
	})
{ _id: ObjectId("62eb00daeb3531cb483e5e0d"),
  id_animal: 2,
  id_cliente: 2,
  nome: 'Renatin pilantra',
  tipo: 'Cachorro',
  raca: 'Doberman',
  pelagem: 'Curto',
  porte: 'Grande',
  idade: 2 }

db.animal.find({
  "raca": "Pitbull"
})
{ _id: ObjectId("62eb00b8eb3531cb483e5e0c"),
  id_animal: 1,
  id_cliente: 1,
  nome: 'Smith',
  tipo: 'Cachorro',
  raca: 'Pitbull',
  pelagem: 'Curto',
  porte: 'Medio',
  idade: 5 }