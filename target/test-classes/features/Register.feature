#language:pt

  @register
Funcionalidade: Como usuário do site Register
  Eu desejo realizar um cadastro
  Para validar se foi cadastro com sucesso

  @test001
    #comentar com jogo da velha

    Cenario: validar cadastro com sucesso no site Register
    Dado que eu acesse o site Register
    Quando preencho o campo nome com valor nome "Valeria" e sobrenome "Falco"
    E preencho o campo endereço com valor "R Joaquim Jacinto"
    E preencho o email com valor "teste@teste.com.br"
    E preencho o campo telefone com valor "11984336478"
    E clico no checkbox feminino
    E clico no checkbox movies
    E seleciono skills "Java"
    E seleciono um country
    E seleciono o ano "1968", o mes "May", o dia "23"

