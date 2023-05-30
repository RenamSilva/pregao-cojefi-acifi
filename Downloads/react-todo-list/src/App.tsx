import { Content } from "./components/Content"
import { Header } from "./components/Header"
import { ToDoContextProvider } from "./contexts/ToDo"
import { ToastProvider } from "./contexts/Toast/inde"


function App() {

  return (
    <>
      <Header />
      <ToastProvider>
        <ToDoContextProvider>
          <Content />
        </ToDoContextProvider>
      </ToastProvider>
    </>
  )
}

export default App
