package main.chapter1.scenario2

interface Alarm {
    fun send(
        message: String,
    )
}

class EmailAlarm(
    private val email: String,
) : Alarm, Observer {
    override fun send(message: String) {
        println("이메일 전송: $message")
    }

    override fun update(goodsEntity: GoodsEntity) {
        val message = "${goodsEntity.name}의 수량이 ${goodsEntity.quantity}개 남았습니다."
        send(message)
    }
}

class SmsAlarm(
    private val phoneNumber: String,
) : Alarm, Observer {
    override fun send(
        message: String,
    ) {
        println("SMS 전송: $message")
    }

    override fun update(goodsEntity: GoodsEntity) {
        val message = "${goodsEntity.name}의 수량이 ${goodsEntity.quantity}개 남았습니다."
        send(message)
    }
}

class NotificationAlarm(
    private val noticeService: NoticeService,
) : Alarm, Observer {
    override fun send(
        message: String,
    ) {
        noticeService.register(message)
    }

    override fun update(goodsEntity: GoodsEntity) {
        val message = "${goodsEntity.name}의 수량이 ${goodsEntity.quantity}개 남았습니다."
        send(message)
    }
}