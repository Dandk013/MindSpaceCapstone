package com.dicoding.mindspace.data

data class Question(
    val questionText: String,
    val questionId : Int
)

val questionList = listOf(
    Question("Apakah kamu sering merasa kesepian?", 1),
    Question("Seberapa sering kamu mengalami emosi yang tidak terkontrol?", 2),
    Question("Seberapa sering kamu bahagia?",3),
    Question("Seberapa sering kamu merasakan gelisah?", 4),
    Question("Seberapa sering kamu merasa tidak berharga/tidak berguna?",5),
    Question("Seberapa sering kamu ingin menyakiti diri sendiri?",6),
    Question("Seberapa sering kamu mengalami insomnia?",7),
    Question("Seberapa sering kamu merasa ingin mengakhiri hidup?",8),
    Question("Seberapa sering kamu merasa sukar fokus?",9),
    Question("Apakah kamu sering merasa mudah tersinggung dengan omongan dan respon orang lain?",10),
)