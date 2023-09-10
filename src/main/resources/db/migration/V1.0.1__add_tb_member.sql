CREATE TABLE IF NOT EXISTS member( 
  
    id                  BIGINT              AUTO_INCREMENT     PRIMARY KEY,
    username            VARCHAR(255)        NOT NULL                                                            COMMENT 'Account',
    password            VARCHAR(255)                                                                            COMMENT 'Password',
    nickname            VARCHAR(255), 
    email               VARCHAR(255),


    -- Account Status
    status            VARCHAR(255)                            DEFAULT 'PENDING'                               COMMENT 'Account status. PENDING | ACTIVE | SUSPENDED | PROTECTED | SLEEP | REMOVED,

    CONSTRAINT uq_account_username          UNIQUE  (username)
);
