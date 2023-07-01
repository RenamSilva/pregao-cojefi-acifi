describe('<No Content>', () => {


    context('Quando não houver conteúdo na pagina:', () => {

    it('Deve exibir a pagina de No Content ', () => {
        cy.visit('http://localhost:3000/NoContent');   

        cy.get('img').should('exist').should('have.attr', 'alt', 'ícone de clipboard')   

        cy.get("strong").should("contain.text", "Você ainda não tem tarefas cadastradas")
        cy.get("p").should("contain.text", "Crie tarefas e organize seus itens a fazer")

    })
   
  })
 })