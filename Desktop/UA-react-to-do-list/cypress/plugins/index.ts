

module.exports = (on: any, config: any) => {
    on('task', require('@cypress/code-coverage/task'))
    return config
  }