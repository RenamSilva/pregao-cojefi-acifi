import { createContext, useState } from "react";
import { Tasks } from "../../models/Tasks";


type ToDoContextProps = {
    tasksListState: Tasks[]
    setTasksListState: React.Dispatch<React.SetStateAction<Tasks[]>>
}


type ToDoContextProviderProps = {
    children: React.ReactNode
}


const DEFAULT_VALUES = {
    tasksListState: [],
    setTasksListState: () => [{}]
}


const ToDoContext = createContext<ToDoContextProps>(DEFAULT_VALUES)


const ToDoContextProvider = ({ children }: ToDoContextProviderProps) => {
    const [tasksListState, setTasksListState] = useState<Tasks[]>([]);
    return (
        <ToDoContext.Provider value={{
            tasksListState,
            setTasksListState
        }}>
            {children}
        </ToDoContext.Provider>
    );
}

export type { ToDoContextProps };

export { ToDoContextProvider };

export default ToDoContext;