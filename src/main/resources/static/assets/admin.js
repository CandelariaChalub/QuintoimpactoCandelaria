const app = Vue.

createApp({
  data() {
    return {
      students: [],
      teachers: [],
      courses: [],
      name: "",
      surname: "",
      description: "",
      timetable: "",
      turnEnum: [],
      turn: "",
      teacherId: "",
      age: 0,
      /* course: [], */
    };
  },
  created() {
    this.loadData();
    this.loadTeachers();
    this.loadCourses();

  },
  mounted() {},
  methods: {
    loadData() {
      axios.get("/api/students/get").then((e) => {
        this.students = e.data;
        console.log("this.students", this.students);
      });
    },
    loadTeachers() {
      axios.get("/api/teachers/get").then((e) => {
        this.teachers = e.data;
        console.log("this.teachers", this.teachers);
      });
    },
    loadCourses() {
      axios.get("/api/courses/get").then((e) => {
        this.courses = e.data;
        this.courses.map(course =>{
          this.turnEnum.push(course.turn)
          } )
        console.log("this.courses", this.courses);
      });
    },
    createStudent() {
      axios
        .post(
          "/api/students/create",
          {
            "name":this.name,
            "surname":this.surname,
            "age":parseInt(this.age),
            /*  "course": this.course, */
          }
        )
        .then(() => alert("Student created"))
        .then(() => window.location.reload())
        .catch((error) => alert(`${error.response.data.message}`));
    },
    deleteStudent(student){
            axios.delete("api/students/delete/" + student.id)
            .then(()=>alert("eliminated student"))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data.message}`))          
        }, 
    createTeacher() {
      axios
        .post(
          "/api/teachers/create",
          {
            "name":this.name,
            "surname":this.surname,
            /*  "course": this.course, */
          }        
        )
        .then(() => alert("Teacher created"))
        .then(() => window.location.reload())
        .catch((error) => alert(`${error.response.data.message}`));
    },
    deleteTeacher(teacher){
            axios.delete("api/teachers/delete/" + teacher.id)
            .then(()=>alert("teacher eliminated"))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data.message}`))          
        }, 
    createCourse() {
      console.log(this)
      axios
        .post(
          "/api/courses/create",
          {
            "name":this.name,
            "description":this.description,
            "timetable":this.timetable,
            "turn":this.turn,
            "teacherId":this.teacherId,
          }
        )
        .then(() => alert("Course created"))
        .then(() => window.location.reload())
        .catch((error) => alert(`${error.response.data.message}`));
    },
    deleteCourse(course){
      console.log(course)
            axios.delete("api/courses/delete/" + course.id)
            .then(()=>alert("course eliminated"))
            .then(()=>window.location.reload())
            .catch(error=>alert(`${error.response.data.message}`))          
        }, 
  },
  computed: {},
  update: {},
}).mount("#app");
