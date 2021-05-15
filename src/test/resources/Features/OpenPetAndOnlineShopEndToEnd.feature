Feature: E2E Miro Service Feature

  @Test
  Scenario Outline: Verify Miro sticker in board while sharing from one user to another user
#    Given I navigate to the Open Miro Login Page
#    When I Login with userName "<User1EmailID>" and password "<Password>" in Miro
#    Then I will clean the created board "<BoardName>" data
#    Given I navigate to the Open Miro Login Page
#    When I Login with userName "<anotherUserEmailID>" and password "<Password>" in Miro
#    Then I will clean the created board "<BoardName>" data
    Given I navigate to the Open Miro Login Page
    When I Login with userName "<User1EmailID>" and password "<Password>" in Miro
    Then I create an board with name "<BoardName>" and Sticker with name "<StickerName>" in Miro board

    Then I share the board with another "<anotherUserEmailID>" user & board "<BoardName>"
    Given I navigate to the Open Miro Login Page
    When I Login with userName "<anotherUserEmailID>" and password "<Password>" in Miro
    Then I will verify the sticker "<StickerName>" in shared board "<BoardName>" with user2

#    Given I navigate to the Open Miro Login Page
#    When I Login with userName "<User1EmailID>" and password "<Password>" in Miro
#    Then I will clean the created board "<BoardName>" data

    Examples:
      | User1EmailID   | Password     | BoardName    |StickerName| anotherUserEmailID |
      | assignmentmiro@gmail.com | Test@123 | BoardMiro  |MiroSticker  |miroassignmenttest@gmail.com|
#      | miroassignmenttest@gmail.com | Test@123 | WhiteBoard |Sticker|assignmentmiro@gmail.com|

