package app
import scalatags.Text.all._

object MinimalApplication extends cask.MainRoutes{
  var messages = Vector(
    ("alice", "Hello World!"),
    ("bob", "I am cow, hear me moo"),
    ("charlie", "I weigh twice as much as you"),
  )

  @cask.get("/")
  def hello() = {
    //"Hello World!"
    html(
      head(
        link(
          rel := "stylesheet",
          href := "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        )
      ),
      body(
        div(cls := "container")(
          h1("Scala Chat!"),
          hr,
          div(
            for((name, msg) <- messages)
            yield p(b(name), " ", msg)
          ),
          hr,
          form(action := "/", method := "post")(
            input(`type` := "text", name := "name", placeholder := "User name", width := "20%"),
            input(`type` := "text", name := "msg", placeholder := "Please write a message!", width := "80%"),
            input(`type` := "submit", width := "20%")
          )
        )
      )
    ).render
  }

  @cask.postForm("/")
  def postHello(name: String, msg: String) = {
    messages = messages :+ (name -> msg)
    hello()
  }

  @cask.post("/do-thing")
  def doThing(request: cask.Request) = {
    new String(request.readAllBytes()).reverse
  }

  initialize()
}
