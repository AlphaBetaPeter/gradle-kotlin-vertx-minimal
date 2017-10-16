package alphabetapeter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Future
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.Router


class ServiceVerticle : AbstractVerticle() {

	override fun start(startFuture: Future<Void>) {
		val router = Router.router(vertx)

		router.route("/").handler({ routingContext ->
			val response = routingContext.response()
			response
					.putHeader("content-type", "application/json")
					.end(JsonObject().put("hello", "world").encode())
		})

		val servicePort = config().getInteger("http.port", 8080)

		vertx
				.createHttpServer()
				.requestHandler({ router.accept(it) })
				.listen(servicePort) { result ->
					if (result.succeeded()) {
						startFuture.complete()
					} else {
						startFuture.fail(result.cause())
					}
				}
	}
}