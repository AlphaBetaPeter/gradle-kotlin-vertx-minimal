package alphabetapeter

import io.vertx.core.Vertx

fun main(args: Array<String>) {
	val vertx = Vertx.vertx()
	vertx.deployVerticle(ServiceVerticle(), { res ->
		if (res.succeeded()) {
			println("Server started")
			println("Deployment id is: ${res.result()}")
		} else {
			println("Deployment failed!")
		}
	})
}

