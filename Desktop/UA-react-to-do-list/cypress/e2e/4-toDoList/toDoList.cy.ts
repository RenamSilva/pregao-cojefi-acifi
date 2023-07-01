describe('<ToDoList>', () => {

    beforeEach(() =>{
        cy.viewport("macbook-15")
        cy.visit('http://localhost:3000/to-do')
    })

    context('Quando acessar a ToDoList', () => {

        describe("Deve ser exibido o header e", () => {

            it('Deve conter uma imagem escrita Todo', () => {          
                cy.get('img').should("be.visible")
              })
            })         
                    
              it('Deve conter um input para adicionar uma nova tarefa', () => {           
                  cy.get('input').should("have.value", "")
                  cy.get("input").should("have.attr", "placeholder", "Adicione uma nova tarefa")
        
                })      
                it('Deve conter um button com a mensagem "Criar"', () => {             
                  cy.get('button').contains('Criar')  
                  cy.get('._button_x3dtl_75 > img').should('exist').should('have.attr', 'alt', 'Ícone de mais')   
                })

                it('Deve conter um container que mostre a menssagem "Tarefas Criadas"', () => {          
                    cy.get('article').contains('Tarefas Criadas');
                  })

                it('Deve conter um container que mostre a menssagem "Concluídas"', () => {               
                    cy.get('article').contains('Concluídas');
                 })

                 it('Deve conter um card com uma tarefa concluída [checked]"', () => {               
                    cy.get('section input[type="checkbox"').should('exist');
                    cy.get('section input[type="checkbox"]').not('[checked="checked"]').should('have.length', 1);
                 })

                 it('Deve verificar se o botão adiciona uma nova tarefa', () => {
                   
                    cy.get('._input_x3dtl_21').type('Nova Tarefa')
                    cy.get('._button_x3dtl_75').click()
                  })

                 
                 it('Deve conter um card com uma tarefa (ou mais) em aberto [uncheck]"', () => {     
                    
                    cy.wait(8000)
                    cy.get('section input[type="checkbox"]').should('exist');
                    cy.get('section input[type="checkbox"]').not('[checked="checked"]').should('have.length', 1);                    cy.get('section input[type="checkbox"]').uncheck()
                    cy.get('section input[type="checkbox"]').should('not.be.checked')
                 })

                 it('Deve ser possível concluir uma tarefa clicando no input"', () => {               
                    cy.get('section input[type="checkbox"]').should('exist');
                    cy.get('input[type="checkbox"]').should('not.be.checked')

                    cy.get('section input[type="checkbox"]').click({ multiple: true })
                    cy.get('section input[type="checkbox"]').should('be.checked')
                   
                 })






                

          
              
                  })})

     
