CREATE TABLE Member
(
    member_id BIGINT PRIMARY KEY,
    username  VARCHAR(255) UNIQUE NOT NULL,
    password  VARCHAR(255)        NOT NULL,
    name      VARCHAR(255)        NOT NULL,
    role      VARCHAR(255)        NOT NULL DEFAULT 'ROLE_USER'
);

CREATE TABLE Category
(
    category_id BIGINT PRIMARY KEY,
    code        VARCHAR(255) UNIQUE NOT NULL,
    label       VARCHAR(255) UNIQUE NOT NULL,
    `usage`     TINYINT(1)          NOT NULL DEFAULT 0
);

INSERT INTO Category
VALUES (1, 'SOCIAL', '소셜', true);
INSERT INTO Category
VALUES (2, 'TECHNOLOGY', '기술', true);
INSERT INTO Category
VALUES (3, 'ENVIRONMENT', '환경', true);
INSERT INTO Category
VALUES (4, 'POLICY', '경제', true);
INSERT INTO Category
VALUES (5, 'CULTURE', '문화', true);

CREATE TABLE Post
(
    post_id    BIGINT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    content    VARCHAR(255) NOT NULL,
    category   BIGINT       NOT NULL,
    created_by BIGINT       NOT NULL,
    created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by BIGINT,
    updated_at DATETIME              DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (category) REFERENCES Category (category_id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    FOREIGN KEY (created_by) REFERENCES Member (member_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (updated_by) REFERENCES Member (member_id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);
