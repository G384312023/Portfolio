import random

def generate_answer():
    digits = list(range(10))
    random.shuffle(digits)
    return digits[:4]

def check_hit_blow(answer, guess):
    hit = sum(a == g for a, g in zip(answer, guess))
    blow = len(set(answer) & set(guess)) - hit
    return hit, blow

answer = generate_answer()
print("Hit and Blow ゲーム開始！（4桁の数字を当ててください）")

while True:
    user_input = input(">>> ")
    if len(user_input) != 4 or not user_input.isdigit():
        print("4桁の数字を入力してください。")
        continue
    guess = [int(d) for d in user_input]
    if len(set(guess)) != 4:
        print("重複しない数字を使ってください。")
        continue
    hit, blow = check_hit_blow(answer, guess)
    print(f"Hit: {hit}, Blow: {blow}")
    if hit == 4:
        print("正解！ゲームクリア！")
        break
