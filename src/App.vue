<template>
  <div id="app">
    <nav>
      <router-link to="/">Home </router-link> |
      <router-link to="/about">About </router-link>|
      <router-link to="/frete">Frete </router-link>|
      <router-link to="/cadastrar-frete">Cadastrar </router-link>
    </nav>
    <router-view />
  </div>
</template>

<style lang="scss">
@import "~bulma/bulma.sass";



#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #1f456b;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #172c25;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
