
db.createCollection("aluno")

db.alunos.insert({
  "nome" : "mateus de castro",
		"data_nascimento" : new Date (2001,09,14)
})
{ acknowledged: true,
  insertedIds: { '0': ObjectId("62eb0480eb3531cb483e5e0e") } }

db.alunos.insertOne({
  "nome" : "pedro henrique",
		"data_nascimento" : new Date (1996,11,01)
})
{ acknowledged: true,
  insertedId: ObjectId("62eb04efeb3531cb483e5e0f") }

db.alunos.insertOne({
  "nome" : "leandra oliveira",
		"data_nascimento" : new Date (2001,10,07)
})
{ acknowledged: true,
  insertedId: ObjectId("62eb0512eb3531cb483e5e10") }

db.alunos.find({})
{ _id: ObjectId("62eb0480eb3531cb483e5e0e"),
  nome: 'mateus de castro',
  data_nascimento: 2001-10-14T03:00:00.000Z }
{ _id: ObjectId("62eb04efeb3531cb483e5e0f"),
  nome: 'pedro henrique',
  data_nascimento: 1996-12-01T02:00:00.000Z }
{ _id: ObjectId("62eb0512eb3531cb483e5e10"),
  nome: 'leandra oliveira',
  data_nascimento: 2001-11-07T02:00:00.000Z }
db.alunos.find({ 
	  "nome" : "pedro henrique"
	})
{ _id: ObjectId("62eb04efeb3531cb483e5e0f"),
  nome: 'pedro henrique',
  data_nascimento: 1996-12-01T02:00:00.000Z }

db.alunos.find({
	  "nome" : "mateus de castro"
	})
{ _id: ObjectId("62eb0480eb3531cb483e5e0e"),
  nome: 'mateus de castro',
  data_nascimento: 2001-10-14T03:00:00.000Z }