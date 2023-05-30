import Trash from '../../assets/trash.svg'
import useToDoContext from '../../hooks/useToDoContext';
import styles from './index.module.css';


interface TodoListProps {

  onDelete: (id: string) => void;
  onChangeCheckbox: (id: string) => void;
}

export const TodoList = ({ onDelete, onChangeCheckbox }: TodoListProps) => {
  const { tasksListState } = useToDoContext()

  return (

    <section className={styles.section_container}>

      {tasksListState.map((tasks) => (
        <article
          key={tasks.id}
          className={styles.content_container}>
          <input
            type="checkbox"
            id={tasks.id}
            onChange={() => onChangeCheckbox(tasks.id)}
            defaultChecked={tasks.isDone} />
          <p className={tasks.isDone ? styles.text_scratched : styles.text} >{tasks.description}</p>
          <img
            className={styles.img}
            src={Trash} alt="Icone de lixeira" onClick={() => onDelete(tasks.id)} />
        </article>
      ))}

    </section>

  )
}
