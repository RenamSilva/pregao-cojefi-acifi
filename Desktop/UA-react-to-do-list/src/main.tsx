/* eslint-disable react-refresh/only-export-components */
import React, { lazy, Suspense } from "react";
import ReactDOM from "react-dom/client";
import "./global.css";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { NoContent } from "./pages/ToDo/components/NoContent";

const LandingPage = lazy(() => import("./pages/LandingPage"));
const ToDo = lazy(() => import("./pages/ToDo"));
const NotFound = lazy(() => import("./components/NotFound"));

const router = createBrowserRouter([
  {
    path: "/",
    element: (
      <Suspense fallback={<div>Loading...</div>}>
        <LandingPage />
      </Suspense>
    ),
    errorElement: (
      <Suspense fallback={<div>Loading...</div>}>
        <NotFound />
      </Suspense>
    ),
  },
  {
    path: "/to-do",
    element: (
      <Suspense fallback={<div>Loading...</div>}>
        <ToDo />
      </Suspense>
    ),
    errorElement: (
      <Suspense fallback={<div>Loading...</div>}>
        <NotFound />
      </Suspense>
    ),
  },

  {
    path: "/NoContent",
    element: (
      <Suspense fallback={<div>Loading...</div>}>
        <NoContent />
      </Suspense>
    ),
    errorElement: (
      <Suspense fallback={<div>Loading...</div>}>
        <NotFound />
      </Suspense>
    ),
  },
]);

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
