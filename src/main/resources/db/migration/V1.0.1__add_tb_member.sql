CREATE TABLE IF NOT EXISTS member( -- 테이블 생성 물리적 설계 DDL
    -- Authentication Core Information
    id                  BIGINT              AUTO_INCREMENT     PRIMARY KEY,
    username            VARCHAR(255)        NOT NULL                                                            COMMENT '계정',
    password            VARCHAR(255)                                                                            COMMENT '비밀번호',
    nickname            VARCHAR(255), -- (int) 사이즈
    email               VARCHAR(255),


    -- Account Status
    status            VARCHAR(255)                            DEFAULT 'PENDING'                               COMMENT '계정 상태. PENDING(가입 대기) | ACTIVE(일반적인 상태. 활성화.) | SUSPENDED(접속이 제한된 계정. BLOCKED.) | PROTECTED(비밀번호 연속으로 틀리는 등 이유로 보호한 계정.) | SLEEP(휴면 계정) | REMOVED(삭제되어 만료 기간까지 비활성 상태로 보존하는 계정) 등',

    CONSTRAINT uq_account_username          UNIQUE  (username)
);