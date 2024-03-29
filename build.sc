import mill._, scalalib._


object app extends ScalaModule{
  def scalaVersion = "2.13.0"
  def ivyDeps = Agg(
    ivy"com.lihaoyi::scalatags:0.7.0",
    ivy"com.lihaoyi::cask:0.3.0"
  )
  object test extends Tests{
    def testFrameworks = Seq("utest.runner.Framework")

    def ivyDeps = Agg(
      ivy"com.lihaoyi::utest::0.7.1",
      ivy"com.lihaoyi::requests::0.2.0",
    )
  }
}
