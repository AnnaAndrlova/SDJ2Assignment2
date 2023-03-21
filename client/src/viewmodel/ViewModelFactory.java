package viewmodel;

import model.Model;

public class ViewModelFactory
{
  private Model model;
  private ChatViewModel chatViewModel;
  private LoginViewModel loginViewModel;

  public ViewModelFactory(Model model)
  {
    this.model = model;
    chatViewModel = new ChatViewModel(model);
    loginViewModel = new LoginViewModel(model);
  }
  public Model getModel()
  {
    return model;
  }
  public LoginViewModel getLoginViewModel()
  {
    return loginViewModel;
  }
  public ChatViewModel getChatViewModel()
  {
    return chatViewModel;
  }
}
