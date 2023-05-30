import styles from "./index.module.css"
import Plus from "../../assets/plus.svg"
import { TodoList } from "../TodoList"
import { NoContent } from "../NoContent"
import { ChangeEvent, useEffect, useState } from "react";
import { v4 as uuidv4 } from 'uuid';

import { api } from "../../configs/api/index";
import useToDoContext from "../../hooks/useToDoContext";
import { useToast } from "../../hooks/useToast";
import { Toast } from "../Toast";


type Task = {
  id: string;
  description: string;
  isDone: boolean;
}

export const Content = () => {


  const [description, setDescription] = useState<string>("");



  const { tasksListState, setTasksListState } = useToDoContext()

  const { showToast } = useToast();



  const tasksDone = tasksListState.filter((task) => {
    return task.isDone !== false;
  })
  const disableButton = !description.length;




  const addTaskOnList = () => {

    const v4Id = uuidv4();
    const newTask = {
      id: v4Id,
      description,
      isDone: false
    }


    api.post("tasks", newTask)
      .then((_response) => setTasksListState((currentValue) => [...currentValue, newTask]))
      .finally(() => setDescription(''))
    showToast({
      message: "Tarefa Adicionada com sucesso",
      type: "success"
    })


  }


  const removeTaskOnList = (id: string) => {
    api.delete(`tasks/${id}`)
      .then(() => setTasksListState((currentValue) => currentValue.filter(tasks => tasks.id !== id)));

  }


  const changeStatusCheckbox = (id: string) => {
    const tasks = tasksListState.find(tasks => tasks.id === id);

    if (tasks) {
      api.patch(`tasks/${id}`, {
        isDone: !tasks.isDone
      })
    }



    const elements = tasksListState.map((tasks) => {
      if (tasks.id === id) {
        return {
          ...tasks,
          isDone: !tasks.isDone
        }
      }
      return tasks;
    });

    setTasksListState(elements);
  }


  useEffect(() => {
    api.get("tasks").then((response) =>

      setTasksListState(response.data as Task[]));
  }, []);



  return (
    <section className={styles['section-container']}>
      <main>

        <article className={styles.input_container}>

          <input
            className={styles.input}
            type="text"
            value={description}
            placeholder="Adicione uma nova tarefa"
            onChange={(e: ChangeEvent<HTMLInputElement>) => setDescription(e.target.value)}>
          </input>

          <button
            className={styles.button}
            disabled={disableButton}
            onClick={() => addTaskOnList()}> Criar
            <img src={Plus} alt="Logo de mais"></img>
          </button>

        </article>

        <article className={styles.content_header}>

          <article className={styles.tasks_container}>
            <p className={styles.task_created}>Tarefas Criadas</p>
            <span className={styles.span_value}>{tasksListState.length}</span>
          </article>

          <article className={styles.tasks_container}>
            <p className={styles.task_done}>Concluidas</p>
            <span className={styles.span_value}>{tasksDone.length} de {tasksListState.length}</span>
          </article>

        </article>

        {tasksListState.length == 0 ? <NoContent /> : <TodoList
          onDelete={removeTaskOnList}
          onChangeCheckbox={changeStatusCheckbox}
        />}

        <Toast message="Tarefa adicionada com sucesso" type="success" />

      </main>
    </section>
  )

} 