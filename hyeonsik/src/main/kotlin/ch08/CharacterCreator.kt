package main.ch08

abstract class CharacterCreator {
    // 템플릿 메서드
    fun createCharacter(): List<String> {
        val log = mutableListOf<String>()
        log.add("캐릭터 생성 시작...")
        log.add(setBaseAttributes())
        log.add(initializeSkills())
        log.add(equipGear())
        log.add(setSpecialAbilities())
        log.add("캐릭터 생성 완료!")
        return log
    }

    protected fun setBaseAttributes(): String {
        return "기본 속성 설정: 힘10, 지능0"
    }

    protected fun initializeSkills(): String {
        return "기본 스킬 초기화: 걷기, 뛰기, 겁나빨리뛰기, 코딩"
    }

    open protected fun equipGear(): String {
        return "기본 장비 장착: 없음^^"
    }

    protected abstract fun setSpecialAbilities(): String

}

class WarriorCreator : CharacterCreator() {
    override fun setSpecialAbilities(): String {
        return "전사 특수 능력 설정: 돌진, 방어벽."
    }
}

class MageCreator : CharacterCreator() {
    override fun setSpecialAbilities(): String {
        return "마법사 특수 능력 설정: 파이어볼, 순간이동."
    }
}

class ArcherCreator : CharacterCreator() {
    override fun setSpecialAbilities(): String {
        return "궁수 특수 능력 설정: 멀티샷, 회피 사격."
    }

    override fun equipGear(): String {
        return "궁수 장비 장착: 활과 화살."
    }
}
