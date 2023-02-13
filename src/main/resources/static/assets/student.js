const nav = document.querySelector("nav");
const btnToggleNav = document.querySelector(".hamburger-menu");
const form = document.querySelector(".hero-gauche form");


// Navbar responsive
btnToggleNav.addEventListener('click', () => {

    nav.classList.toggle("active");
    btnToggleNav.classList.toggle("active");

})

// The prevent default form
form.addEventListener("submit", (e) => {

    e.preventDefault();

})

/*
const app = Vue.
    createApp({
    data() {
        return {
        name: "",
        surname: "",
        age: 0,
        course: [],
        }
    },

    created() {
        axios.get('/student')
        .then(response => {
            this.student = response.data;
            console.log(this.student)
        })
        .catch(function (error) { console.log(error) })
    


    
},
    methods: {
        registerStudent() {
        Swal.fire({
            title: '¿Are you sure you want to enroll in this course??',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, enroll!'
        })
        .then((result) => {
            if (result.isConfirmed) {
                axios.post('/student/enrollStudent',
                "name=" + this.name + "&surname=" + this.surname + "&age=" + this.age + "&course=" + this.course)
                .then(
                Swal.fire(
                    'Enrolled!',
                    'You have been successfully enrolled!',
                    'success')
                    .then(response => window.location.reload())
                )
            }
        })
      },

    borrarAlumno() {
        axios.delete('/api/alumno', `nombre=${this.nombreBorrar}`)
            .then(x => window.location.reload())
            .catch(response => Swal.fire({
            icon: 'error',
            title: 'Oops..!',
            text: 'Algún dato es incorrecto!',
            }))
        }
    }
    }
    )
.mount('#app');*/