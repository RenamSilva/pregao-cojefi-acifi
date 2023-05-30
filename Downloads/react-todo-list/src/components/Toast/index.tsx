import { useContext, useEffect, useState } from "react";
import styles from "./index.module.css";
import { useToast } from "../../hooks/useToast";

type ToastPropos = {
  message: string;
  type: "success" | "danger";
};

export const Toast = ({ message, type }: ToastPropos) => {
  const { isHidden } = useToast();

  return (
    <aside className={isHidden ? styles.container : styles.container_show}>
      <p className={type == "success" ? styles.success : styles.danger}>
        {message}
      </p>
    </aside>
  );
};
