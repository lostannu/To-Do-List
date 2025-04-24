document.addEventListener('DOMContentLoaded', function() {
    const todosList = document.getElementById('todos-list');
    const addTaskButton = document.getElementById('add-task-button');
    const taskInput = document.getElementById('task-input');

    function fetchTodos() {
        fetch('/api/todos')
            .then(response => response.json())
            .then(todos => {
                todosList.innerHTML = '';
                todos.forEach(todo => {
                    const todoItem = document.createElement('div');
                    todoItem.textContent = todo.task;
                    const deleteButton = document.createElement('button');
                    deleteButton.textContent = 'Delete';
                    deleteButton.addEventListener('click', function() {
                        deleteTodoItem(todo.id);
                    });
                    todoItem.appendChild(deleteButton);
                    todosList.appendChild(todoItem);
                });
            });
    }

    addTaskButton.addEventListener('click', function() {
        const newTask = taskInput.value;
        if (newTask) {
            const newTodo = { task: newTask, completed: false };
            fetch('/api/todos', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(newTodo)
            })
                .then(response => response.json())
                .then(() => {
                    taskInput.value = '';
                    fetchTodos();
                });
        }
    });

    function deleteTodoItem(id) {
        fetch(`/api/todos/${id}`, { method: 'DELETE' })
            .then(() => fetchTodos());
    }

    fetchTodos();
});
